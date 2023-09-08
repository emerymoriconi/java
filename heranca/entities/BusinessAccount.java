package entities;

public class BusinessAccount extends Account{
	//UPCASTING: casting da subclasse para superclasse
	//DOWNCASTING: casting da superclasse para subclasse (instanceof)
	private Double loanLimit;
	
	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance); //chamando o construtor da superclasse pra nao ter que repetir
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public void loan(double amount) {
		if (amount <= loanLimit) {
			balance += amount - 10.0;
		}
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount); //outra forma de utilizar o super, chama o metodo da superclasse
		balance -= 2.0; //apenas o que diferencia o metodo da superclasse para a subclasse 
	}
}
