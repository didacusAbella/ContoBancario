package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

public class BankAccount implements Cloneable {

	public BankAccount(){

	}

	public BankAccount(ClientRecord client, double balance, String iban) {
		this.accountHolder = client;
		this.balance = balance;
		this.iban = iban;
	}

	public void deposit(double amount) throws IllegalBankAccountException {
		if (amount < 0) 
			throw new IllegalArgumentException("Can not deposit negative ammount!");
		this.balance += amount;
	}

	public void withdraw(double amount) throws IllegalBankAccountException {
		if (amount < 0 || amount > this.balance)
			throw new IllegalArgumentException("Can not withdraw illegal ammount!");
		this.balance -= amount;
	}

	public void interest() throws IllegalBankAccountException  {
		throw new IllegalBankAccountException();
	}

	public void charge() throws IllegalBankAccountException {
		throw new IllegalBankAccountException();
	}

	public void plafond(double plafond) throws IllegalBankAccountException {
		throw new IllegalBankAccountException();
	}

	public void read() {
		System.out.println("Balance is: " + this.balance + "€");
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ClientRecord getAccountHolder() {
		return accountHolder;
	}

	public void setAccountholder(ClientRecord accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getIban() {
		return iban;
	}

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
