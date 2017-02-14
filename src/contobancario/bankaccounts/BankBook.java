package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;

/**
 * The Class BankBook.
 *
 */
public class BankBook extends BankAccount {
	
	/**
	 * Initialize a new BankBook.
	 * 
	 */
	public BankBook() {
		this.interest = 0;
	}
	
	/**
	 * Initialize a new BankBook with his interest.
	 * 
	 * @param interest the interest
	 */
	public BankBook(double interest) {
		this.interest = interest;
	}
	
	@Override
	public void withdraw(double amount) throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Illegal operation on BankBook");
	}
	
	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Illegal operation on BankBook");
	}
	
	private double interest;
	
}
