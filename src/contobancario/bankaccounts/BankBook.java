package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

/**
 * The Class BankBook.
 *
 */
public class BankBook extends BankAccount implements Cloneable {

	/**
	 * Initialize a new BankBook.
	 * 
	 */
	public BankBook() {
		super();
		this.interest = 0;
	}

	/**
	 * 
	 * @param client the client
	 * @param balance the balance
	 * @param iban the iban
	 * @param interest
	 * @throws IllegalBankAccountException
	 */
	public BankBook(ClientRecord client, double balance, String iban, double interest) 
			throws IllegalBankAccountException {
		super(client, balance, iban);
		if (balance < 0)
			throw new IllegalBankAccountException("Cannot insert negative balance");
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

	/**
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}

	/**
	 * @param interest the interest to set
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "BankBook [interest=" + interest + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankBook other = (BankBook) obj;
		return
				this.interest == other.interest;
	}

	@Override
	public Object clone() {
		BankBook cloned = (BankBook) super.clone(); 
		cloned.interest = this.interest;
		return cloned;
	}

	private double interest;

}
