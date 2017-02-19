package contobancario.model;

import java.util.GregorianCalendar;

import contobancario.bankaccounts.BankAccount;
import contobancario.exceptions.IllegalBankAccountException;

public class Transition implements Cloneable {

	public Transition() {
		this.account = null;
		this.toAccount = null;
		this.amount = 0;
		this.date = null;
		this.plafond = 0;
	}

	public Transition(BankAccount from, BankAccount to, double amount, GregorianCalendar date) {
		this.account = from;
		this.toAccount = to;
		this.amount = amount;
		this.date = date;
		this.plafond = 0;
	}
	
	public Transition(BankAccount account, double amount, GregorianCalendar date) {
		this.account = account;
		this.toAccount = null;
		this.amount = amount;
		this.date = date;
		this.plafond = 0;
	}
	
	public Transition(BankAccount account, GregorianCalendar date) {
		this.account = account;
		this.toAccount = null;
		this.amount = 0;
		this.date = date;
		this.plafond = 0;
	}
	
	public Transition(BankAccount account, GregorianCalendar date, double plafond) {
		this.account = account;
		this.toAccount = null;
		this.amount = 0;
		this.date = date;
		this.plafond = plafond;
	}

	public void run(String cmd) throws IllegalBankAccountException {
		switch (cmd) {
		case "move":
			this.account.withdraw(amount);
			this.toAccount.deposit(amount);	
			break;
		case "add":
			this.account.deposit(amount);
			break;
		case "withdraw":
			this.account.withdraw(amount);
			break;	
		case "interest":
			this.account.interest();
			break;
		case "charge":
			this.account.charge();
			break;
		case "plafond":
			this.account.plafond(plafond);
			break;
		default:
			throw new IllegalArgumentException("Invalid command!");
		}
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setFromAccount(BankAccount account) {
		this.account = account;
	}

	public BankAccount getToAccount() {
		return toAccount;
	}

	public void setToAccount(BankAccount toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" +
				"account=" + account + ", " +
				"toAccount=" + toAccount + ", " +
				"amount=" + amount + ", " +
				"date=" + date.getTime() + ", " +
				"plafond=" + plafond +
				"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transition other = (Transition) obj;
		return
				this.account.equals(other.account) &&
				this.toAccount.equals(other.toAccount) &&
				this.amount == other.amount &&
				this.date.equals(other.date) &&
				this.plafond == other.plafond;
	}

	@Override
	public Object clone() {
		try {
			Transition cloned = (Transition) super.clone(); 
			cloned.account = (BankAccount) this.account.clone();
			cloned.toAccount = (BankAccount) this.toAccount.clone();
			cloned.amount = this.amount;
			cloned.date = (GregorianCalendar) this.date.clone();
			cloned.plafond = this.plafond;
			return cloned; 
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	private BankAccount account;
	private BankAccount toAccount;
	private double amount;
	private GregorianCalendar date;
	private double plafond;
}
