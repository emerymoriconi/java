package entities;

public class SavingsAccount extends Account{
	//"final" em "public final class" evita que sejam criadas subclasses da classe SavingsAccount
	//alem de deixar o programa mais rapido em tempo de execução
	private Double interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance); //executa o construtor da superclasse
		this.interestRate = interestRate; //complemento do construtor
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	@Override //prática de boas maneiras,indica um método sobrescrito da classe pai
	public final void withdraw(double amount) { //"final" nao permite que o metodo seja sobreposto por outras classes
		balance -= amount;
	}
	//final é recomendado usar é metodos que ja foram sobrepostos
	//pois sobreposicoes multiplas correm o risco de trazer inconsistencias
}
