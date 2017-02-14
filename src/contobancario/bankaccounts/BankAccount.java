package contobancario.bankaccounts;

import contobancario.model.ClientRecord;

/**
 * The Class BankAccount.
 *
 */
public class BankAccount implements Cloneable {

	/**
	 * Initializes a new bank account.
	 */
	public BankAccount(){

	}

	/**
	 * Initializes a new bank account with his client, balance and iban.
	 * 
	 * @param client the bank account's client
	 * @param balance the bank account's balance
	 * @param iban the bank account'e iban
	 */
	public BankAccount(ClientRecord client, double balance, String iban) {
		this.accountHolder = client;
		this.balance = balance;
		this.iban = iban;
	}

	/**
	 * Deposited the amount in the bank account.
	 * 
	 * @param amount the amount that it must deposit
	 */
	public void deposit(double amount) {
		if (amount < 0) 
			throw new IllegalArgumentException("Can not deposit negative ammount!");
		this.balance += amount;
	}
	
	/**
	 * Withdraw the amount from the bank account.
	 * 
	 * @param amount the amount that it must withdraw
	 */
	public void withdraw(double amount) {
		if (amount < 0 || amount > this.balance)
			throw new IllegalArgumentException("Can not withdraw illegal ammount!");
		this.balance -= amount;
	}
	
	/**
	 * Read the balance of the bank account.
	 */
	public void read() {
		System.out.println("Your balance is: " + this.balance);
	}

	/**
	 * @return the account holder
	 */
	public ClientRecord getAccountHolder() {
		return accountHolder;
	}

	/**
	 * @param accountHolder the account holder to set
	 */
	public void setAccountholder(ClientRecord accountHolder) {
		this.accountHolder = accountHolder;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/** 
	 * Return a string representation of the structure object.
	 * 
	 * @return string representation of the object
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" + 
				"accountHolder=" + this.accountHolder + 
				", balance=" + this.balance + 
				", iban=" + this.iban + 
				"]";
	}

	/**
	 * Make a "deep" comparison between this object and another object.
	 * 
	 * @return true, if the comparated object have the same class and the same properties
	 */
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
	
	/**
	 * Make a "deep" copy of this object.
	 * 
	 * @return cloned, the clone of this object
	 */
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

	private ClientRecord accountHolder;
	private double balance;
	private String iban;
}
