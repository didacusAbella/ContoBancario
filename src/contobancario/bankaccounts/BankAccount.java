package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

/**
 * The class BankAccount.
 *
 */
public class BankAccount implements Cloneable {

	/**
	 * Instantiates a new BankAccount.
	 */
	public BankAccount() {

	}

	/**
	 * Instantiates a new BankAccount.
	 * 
	 * @param client the client
	 * @param balance the balance
	 * @param iban the iban
	 */
	public BankAccount(ClientRecord client, double balance, String iban) {
		this.accountHolder = client;
		this.balance = balance;
		this.iban = iban;
	}

	/**
	 * Deposited the amount.
	 * 
	 * @param amount the amount
	 * @throws IllegalBankAccountException
	 */
	public void deposit(double amount) throws IllegalBankAccountException {
		if (amount < 0) 
			throw new IllegalArgumentException("Can not deposit negative ammount!");
		this.balance += amount;
	}

	/**
	 * Withdraws the amount.
	 * @param amount
	 * @throws IllegalBankAccountException
	 */
	public void withdraw(double amount) throws IllegalBankAccountException {
		if (amount < 0 || amount > this.balance)
			throw new IllegalArgumentException("Can not withdraw illegal ammount!");
		this.balance -= amount;
	}

	/**
	 * Accredits interests.
	 * 
	 * @throws IllegalBankAccountException
	 */
	public void interest() throws IllegalBankAccountException  {
		throw new IllegalBankAccountException();
	}

	/**
	 * Accredits charges.
	 * 
	 * @throws IllegalBankAccountException
	 */
	public void charge() throws IllegalBankAccountException {
		throw new IllegalBankAccountException();
	}

	/**
	 * Fixed the plafond
	 * 
	 * @param plafond the plafond
	 * @throws IllegalBankAccountException
	 */
	public void plafond(double plafond) throws IllegalBankAccountException {
		throw new IllegalBankAccountException();
	}

	/**
	 * Read the balance.
	 * 
	 */
	public void read() {
		System.out.println("Balance is: " + this.balance + "â‚¬");
	}

	/**
	 * Gets the bankaccount's data in a readable format.
	 * 
	 * @return the bankaccount's data
	 */
	public String toFormat() {
		return
				this.iban + " " +
				this.accountHolder.getName() + " " + 
				this.accountHolder.getSurname() + "\t" +
				this.balance + "€";
	}

	/**
	 * Gets the balance.
	 * 
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 * 
	 * @param balance the balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Gets the account holder.
	 * 
	 * @return the account holder
	 */
	public ClientRecord getAccountHolder() {
		return accountHolder;
	}

	/**
	 * Sets the account holder.
	 * 
	 * @param accountHolder the account holder
	 */
	public void setAccountholder(ClientRecord accountHolder) {
		this.accountHolder = accountHolder;
	}

	/**
	 * Gets the iban
	 * 
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * Sets the iban.
	 * 
	 * @param iban the iban
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" + 
				"accountHolder=" + this.accountHolder + 
				", balance=" + this.balance + 
				", iban=" + this.iban + 
				"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return
				this.accountHolder.equals(other.accountHolder) &&
				this.balance == other.balance &&
				this.iban.equals(other.balance);
	}

	@Override
	public Object clone() {
		try {
			BankAccount cloned = (BankAccount) super.clone(); 
			cloned.accountHolder = (ClientRecord) this.accountHolder.clone(); 
			cloned.balance = this.balance;
			cloned.iban = this.iban;
			return cloned; 
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	protected double balance;

	private ClientRecord accountHolder;
	private String iban;
}
