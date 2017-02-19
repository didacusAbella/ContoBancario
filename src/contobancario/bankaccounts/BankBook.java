package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

/**
 * The class BankBook. 
 *
 */
public class BankBook extends BankAccount {

	/**
	 * Instantiates a new BankBook.
	 * 
	 */
	public BankBook() {
		super();
		this.interest = 0;
	}

	/**
	 * Instantiates a new BankBook.
	 * 
	 * @param client the client
	 * @param balance the balance
	 * @param iban the iban
	 * @param interest the interest
	 * @throws IllegalBankAccountException
	 */
	public BankBook(ClientRecord client, double balance, String iban, double interest) throws IllegalBankAccountException {
		super(client, balance, iban);
		if (balance < 0)
			throw new IllegalBankAccountException("Cannot insert negative balance");
		this.interest = interest;
	}

	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		super.deposit(amount);
	}

	@Override
	public void withdraw(double amount) throws IllegalBankAccountException {
		super.withdraw(amount);
	}

	@Override
	public void interest() {
		super.balance += (super.balance/100) * this.interest;
	}

	@Override
	public void charge() throws IllegalBankAccountException {
		throw new IllegalBankAccountException("A BankBook may not have charges!");
	}

	@Override
	public void plafond(double plafond) throws IllegalBankAccountException {
		throw new IllegalBankAccountException("A BankBook does not have a plafond!");
	}

	/**
	 * Gets the interest.
	 * 
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}

	/**
	 * Sets the interest.
	 * 
	 * @param interest the interest
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return super.toString() + "[" +
				"interest=" + interest + 
				"]";
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
