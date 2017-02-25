package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

/**
 * The class CheckingAccount.
 *
 */
public class CheckingAccount extends BankAccount {

	/**
	 * Instantiates a new CheckingAccount.
	 * 
	 */
	public CheckingAccount() {
		super();
		this.plafond = 0;
		this.transitions = 0;
	}

	/**
	 * Instantiates a new CheckingAccount.
	 * 
	 * @param client the client
	 * @param balance the balance
	 * @param iban the iban
	 * @throws IllegalBankAccountException
	 */
	public CheckingAccount(ClientRecord client, double balance, String iban) throws IllegalBankAccountException {
		super(client, balance, iban);
		this.plafond = 0;
		this.transitions = 0;
		if (plafond > 0) 
			throw new IllegalBankAccountException("Plafond must be negative!");
		if (balance < plafond)
			throw new IllegalBankAccountException("Balance over the bank trust!");
	}

	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		super.deposit(amount);
		if (super.balance < 0) {
			this.transitions++;
		}
		else
			this.transitions = 0;
	}

	@Override
	public void withdraw(double amount) throws IllegalBankAccountException {
		if (amount < 0 || (super.balance - amount) < plafond)
			throw new IllegalArgumentException("Can not withdraw illegal ammount!");
		super.balance -= amount;
		if (super.balance < 0) 
			transitions++;
	}

	@Override
	public void interest() throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Can not be credited interests to a CheckingAccount!");
	}

	@Override
	public void charge() throws IllegalBankAccountException {
		if (this.transitions > FREE_TRANSITIONS) {
			super.balance -= FIXED_CHARGE;
			super.balance -= CHARGE * (this.transitions - FREE_TRANSITIONS);
		}
	}

	@Override
	public void plafond(double plafond) throws IllegalBankAccountException {
		if (plafond > 0)
			throw new IllegalBankAccountException("A CheckingAccount's plafond must be negative!");
		this.plafond = plafond;
	}

	@Override
	public String toFormat() {
		return super.toFormat() +
				"\t\t" + "plf: " + this.plafond + "€" ;
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

	/**
	 * Gets the transitions.
	 * 
	 * @return the transitions
	 */
	public int getTransitions() {
		return transitions;
	}

	/**
	 * Sets the transitions.
	 * 
	 * @param transitions
	 */
	public void setTransitions(int transitions) {
		this.transitions = transitions;
	}

	@Override
	public String toString() {
		return super.toString() + "[" +
				"plafond=" + plafond + ", " + 
				"transitions=" + transitions + 
				"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckingAccount other = (CheckingAccount) obj;
		return
				this.transitions == other.transitions &&
				this.plafond == other.plafond;
	}

	@Override
	public Object clone() {
		CheckingAccount cloned = (CheckingAccount) super.clone(); 
		cloned.transitions = this.transitions;
		cloned.plafond = this.plafond;
		return cloned;
	}

	private double plafond;
	private int transitions;

	private static int FREE_TRANSITIONS = 2;
	private static double FIXED_CHARGE = 1.50;
	private static double CHARGE = 0.50;
}
