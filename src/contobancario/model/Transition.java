package contobancario.model;

import java.util.GregorianCalendar;

import contobancario.bankaccounts.BankAccount;
import contobancario.exceptions.IllegalBankAccountException;

/**
 * The class Transition.
 *
 */
public class Transition implements Cloneable {

	/**
	 * Instantiates a new Transition.
	 * 
	 */
	public Transition() {
		this.account = null;
		this.toAccount = null;
		this.amount = 0;
		this.date = null;
		this.plafond = 0;
	}

	/**
	 * Instantiates a new Transition.
	 * 
	 * @param from the from account
	 * @param to the to account
	 * @param amount the amount
	 * @param date the date
	 */
	public Transition(BankAccount from, BankAccount to, double amount, GregorianCalendar date) {
		this.account = from;
		this.toAccount = to;
		this.amount = amount;
		this.date = date;
		this.plafond = 0;
	}

	/**
	 * Instantiates a new Transition.
	 * 
	 * @param account the account
	 * @param amount the amount
	 * @param date the date
	 */
	public Transition(BankAccount account, double amount, GregorianCalendar date) {
		this.account = account;
		this.toAccount = null;
		this.amount = amount;
		this.date = date;
		this.plafond = 0;
	}

	/**
	 * Instantiates a new Transition.
	 * 
	 * @param account the account
	 * @param date the date
	 */
	public Transition(BankAccount account, GregorianCalendar date) {
		this.account = account;
		this.toAccount = null;
		this.amount = 0;
		this.date = date;
		this.plafond = 0;
	}

	/**
	 * Instantiates a new Transition.
	 * 
	 * @param account the account
	 * @param date the date
	 * @param plafond the plafond
	 */
	public Transition(BankAccount account, GregorianCalendar date, double plafond) {
		this.account = account;
		this.toAccount = null;
		this.amount = 0;
		this.date = date;
		this.plafond = plafond;
	}

	/**
	 * Performs the requested operation. 
	 * If "move", it moves the amount from the origin account to the destination account; 
	 * "add" pour the amount to the account; 
	 * "withdraw" withdraw the amount to the account; 
	 * "interest" accredits the interest to the account; 
	 * "charge" accredits the charges to the account; 
	 * "plafond" sets the plafond of the account.
	 * 
	 * @param cmd the command
	 * @throws IllegalBankAccountException
	 */
	public void run(String cmd) throws IllegalBankAccountException {
		switch (cmd) {
		case "move":
			this.type = "move";
			this.account.withdraw(amount);
			this.toAccount.deposit(amount);	
			break;
		case "add":
			this.type = "add";
			this.account.deposit(amount);
			break;
		case "withdraw":
			this.type = "withdraw";
			this.account.withdraw(amount);
			break;	
		case "interest":
			this.type = "interest";
			this.account.interest();
			break;
		case "charge":
			this.type = "charge";
			this.account.charge();
			break;
		case "plafond":
			this.type = "plafond";
			this.account.plafond(plafond);
			break;
		default:
			throw new IllegalArgumentException("Invalid command!");
		}
	}
	
	/**
	 * Gets the transition's data in a readable format.
	 * 
	 * @return the bankaccount's data
	 */
	public String toFormat() {
		if (this.type.equals("move")) {
			return 
					this.date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (this.date.get(GregorianCalendar.MONTH) + 1) + "/" + this.date.get(GregorianCalendar.YEAR) +
					" " + this.date.get(GregorianCalendar.HOUR_OF_DAY) + ":" + this.date.get(GregorianCalendar.MINUTE) + " - " +
					"Move " + this.amount + "€ from " + this.account.getIban() + " to " + this.toAccount.getIban() + ".";
		}
		if (this.type.equals("add")) {
			return
					this.date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (this.date.get(GregorianCalendar.MONTH) + 1) + "/" + this.date.get(GregorianCalendar.YEAR) + 
					" " + this.date.get(GregorianCalendar.HOUR_OF_DAY) + ":" + this.date.get(GregorianCalendar.MINUTE) + " - " +
					"Deposit " + this.amount + "€ to " +this.account.getIban() + ".";
		} 
		if (this.type.equals("withdraw")) {
			return 
					this.date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (this.date.get(GregorianCalendar.MONTH) + 1) + "/" + this.date.get(GregorianCalendar.YEAR) +
					" " + this.date.get(GregorianCalendar.HOUR_OF_DAY) + ":" + this.date.get(GregorianCalendar.MINUTE) + " - " +
					"Withdraw " + this.amount + "€ to " +this.account.getIban() + ".";
		}
		if (this.type.equals("interest")) {
			return 
					this.date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (this.date.get(GregorianCalendar.MONTH) + 1) + "/" + this.date.get(GregorianCalendar.YEAR) +
					" " + this.date.get(GregorianCalendar.HOUR_OF_DAY) + ":" + this.date.get(GregorianCalendar.MINUTE) + " - " +
					"Add Interest to " + this.account.getIban() + ".";
		}
		if (this.type.equals("charge")) {
			return 
					this.date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (this.date.get(GregorianCalendar.MONTH) + 1) + "/" + this.date.get(GregorianCalendar.YEAR) +
					" " + this.date.get(GregorianCalendar.HOUR_OF_DAY) + ":" + this.date.get(GregorianCalendar.MINUTE) + " - " +
					"Add Charge to " + this.account.getIban() + ".";
		}
		if (this.type.equals("plafond")) {
			return 
					this.date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (this.date.get(GregorianCalendar.MONTH) + 1) + "/" + this.date.get(GregorianCalendar.YEAR) + 
					" " + this.date.get(GregorianCalendar.HOUR_OF_DAY) + ":" + this.date.get(GregorianCalendar.MINUTE) + " - " +
					"Set " + this.plafond + "€ of plafond to " + this.account.getIban() + ".";
		}
		return null;
	}

	/**
	 * Gets the origin account.
	 * 
	 * @return the origin account
	 */
	public BankAccount getAccount() {
		return account;
	}

	/**
	 * Sets the origin account.
	 * 
	 * @param account the origin account
	 */
	public void setAccount(BankAccount account) {
		this.account = account;
	}

	/**
	 * Gets the destination account.
	 * 
	 * @return the destination account
	 */
	public BankAccount getToAccount() {
		return toAccount;
	}

	/**
	 * Sets the destination account.
	 * 
	 * @param toAccount the destination account
	 */
	public void setToAccount(BankAccount toAccount) {
		this.toAccount = toAccount;
	}

	/**
	 * Gets the amount.
	 * 
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 * 
	 * @param amount the amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date the date
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	/**
	 * Gets the plafond.
	 * 
	 * @return the plafond
	 */
	public double getPlafond() {
		return plafond;
	}

	/**
	 * Sets the plafond.
	 * 
	 * @param plafond the plafond
	 */
	public void setPlafond(double plafond) {
		this.plafond = plafond;
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
	private String type;
}
