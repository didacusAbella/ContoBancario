package contobancario.model;

import java.util.GregorianCalendar;

import contobancario.bankaccounts.BankAccount;

/**
 * The Class Transition.
 * 
 */
public class Transition implements Cloneable {
	
	/**
	 * Initialize a new transition.
	 * 
	 */
	public Transition() {
		this.fromAccount = null;
		this.toAccount = null;
		this.amount = 0;
		this.date = null;
		this.plafont = 0;
	}
	
	/**
	 * Initialize a new transition with his origin account, destination account, amount,
	 * date and plafond.
	 * 
	 * @param from the origin account
	 * @param to the destination account
	 * @param amount the amount
	 * @param date the date
	 * @param plafond the plafond
	 */
	public Transition(BankAccount from, BankAccount to, double amount, 
			GregorianCalendar date, double plafond) {
		this.fromAccount = from;
		this.toAccount = to;
		this.amount = amount;
		this.date = date;
		this.plafont = plafond;
	}
	
	/**
	 * Executes a command on the bank accounts.
	 * If insert "move", the method moves the amount from origin account to destination 
	 * account;
	 * "pour", the method deposited the amount on the origin account;
	 * "withdraw", the the method withdraw the amount on the origin account.
	 * 
	 * @param cmd the command
	 */
	public void run(String cmd) {
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
		default:
			throw new IllegalAccessError("Invalid command!");
		}
	}
	
	/**
	 * @return the fromAccount
	 */
	public BankAccount getFromAccount() {
		return fromAccount;
	}

	/**
	 * @param fromAccount the fromAccount to set
	 */
	public void setFromAccount(BankAccount fromAccount) {
		this.fromAccount = fromAccount;
	}

	/**
	 * @return the toAccount
	 */
	public BankAccount getToAccount() {
		return toAccount;
	}

	/**
	 * @param toAccount the toAccount to set
	 */
	public void setToAccount(BankAccount toAccount) {
		this.toAccount = toAccount;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	/**
	 * @return the plafont
	 */
	public double getPlafont() {
		return plafont;
	}

	/**
	 * @param plafont the plafont to set
	 */
	public void setPlafont(double plafont) {
		this.plafont = plafont;
	}

	/** 
	 * Return a string representation of the structure object.
	 * 
	 * @return string representation of the object
	 */
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
		Transition other = (Transition) obj;
		return
				this.fromAccount.equals(other.fromAccount) &&
				this.toAccount.equals(other.toAccount) &&
				this.amount == other.amount &&
				this.date.equals(other.date) &&
				this.plafont == other.plafont;
	}
	
	/**
	 * Make a "deep" copy of this object.
	 * 
	 * @return cloned, the clone of this object
	 */
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
}
