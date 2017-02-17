package contobancario.model;

import java.util.GregorianCalendar;
import java.util.Scanner;

import contobancario.bankaccounts.BankAccount;
import contobancario.exceptions.IllegalBankAccountException;


public class Transition implements Cloneable {

	public Transition() {
		this.fromAccount = null;
		this.toAccount = null;
		this.amount = 0;
		this.date = null;
		this.plafont = 0;
		this.interest = 0;
	}

	public Transition(BankAccount from, BankAccount to, double amount, 
			GregorianCalendar date, double plafond) {
		this.fromAccount = from;
		this.toAccount = to;
		this.amount = amount;
		this.date = date;
		this.plafont = plafond;
	}

	public Transition(BankAccount from, GregorianCalendar date, double plafond, 
			double interest) {
		this.fromAccount = from;
		this.date = date;
		this.plafont = plafond;
		this.interest = interest;
	}

	public void run(String cmd) throws IllegalBankAccountException {
		switch (cmd) {
		case "move":
			this.fromAccount.withdraw(amount);
			this.toAccount.deposit(amount);			
			break;
		case "pour":
			this.fromAccount.deposit(amount);
			break;
		case "withdraw":
			this.fromAccount.withdraw(amount);
			break;	
		case "interest":
			this.fromAccount.deposit((this.fromAccount.getBalance() / 100) * this.interest);
			break;
		case "Plafond":
			this.setPlafont(plafont);
			break;
		default:
			throw new IllegalArgumentException("Invalid command!");
		}
	}

	public BankAccount getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(BankAccount fromAccount) {
		this.fromAccount = fromAccount;
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

	public double getPlafont() {
		return plafont;
	}

	public void setPlafont(double plafont) {
		this.plafont = plafont;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" +
				"fromAccount=" + fromAccount + ", " +
				"toAccount=" + toAccount + ", " +
				"amount=" + amount + ", " +
				"date=" + date + ", " +
				"plafont=" + plafont + ", " +
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
				this.fromAccount.equals(other.fromAccount) &&
				this.toAccount.equals(other.toAccount) &&
				this.amount == other.amount &&
				this.date.equals(other.date) &&
				this.plafont == other.plafont;
	}

	@Override
	public Object clone() {
		try {
			Transition cloned = (Transition) super.clone(); 
			cloned.fromAccount = (BankAccount) this.fromAccount.clone();
			cloned.toAccount = (BankAccount) this.toAccount.clone();
			cloned.amount = this.amount;
			cloned.date = (GregorianCalendar) this.date.clone();
			cloned.plafont = this.plafont;
			return cloned; 
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	private BankAccount fromAccount;
	private BankAccount toAccount;
	private double amount;
	private GregorianCalendar date;
	private double plafont;
	private double interest;
}
