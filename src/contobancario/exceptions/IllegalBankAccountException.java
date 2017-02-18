package contobancario.exceptions;

public class IllegalBankAccountException extends Exception {
	
	public IllegalBankAccountException() {
		super();
	}
		
	public IllegalBankAccountException(String message) {
		super(message);
	}
}
