package model.exceptions;

public class DomainException extends RuntimeException{
	//extends RunTimeException: compilador nao obriga a tratar (com try-catch)
	//extends Exception: compilador obriga a tratar (com try-catch)
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
