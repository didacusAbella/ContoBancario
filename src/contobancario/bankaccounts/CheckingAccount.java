package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

/**
 * The Class CheckingAccount.
 *
 */
public class CheckingAccount extends BankAccount {

	/**
	 * Initialize a new checking account.
	 * 
	 */
	public CheckingAccount() {
		super();
		this.trust = 0;
	}

	/**
	 * Initialize a new checking account with his client, balance, iban and trust.
	 * 
	 * @param client the client
	 * @param balance the balance
	 * @param iban the iban
	 * @param trust the trust
	 * @throws IllegalBankAccountException
	 */
	public CheckingAccount(ClientRecord client, double balance, String iban, double trust) 
			throws IllegalBankAccountException {
		super(client, balance, iban);
		this.trust = trust;
		if (balance < trust)
			throw new IllegalBankAccountException("Balance over the bank trust!");
	}

	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		super.deposit(amount);
		if (super.balance < this.trust)
			this.freeTransition--;
	}

	@Override
	public void withdraw(double amount) throws IllegalBankAccountException {
		if (amount < 0 || (super.balance - amount) < trust)
			throw new IllegalArgumentException("Can not withdraw illegal ammount!");
		if (super.balance < this.trust) 
			freeTransition--;
		super.balance -= amount;
	}


	/**
	 * @return the trust
	 */
	public double getTrust() {
		return trust;
	}

	/**
	 * @param trust the trust to set
	 */
	public void setTrust(double trust) {
		this.trust = trust;
	}

	/**
	 * @return the freeTransition
	 */
	public int getFreeTransition() {
		return freeTransition;
	}

	/**
	 * @param freeTransition the freeTransition to set
	 */
	public void setFreeTransition(int freeTransition) {
		this.freeTransition = freeTransition;
	}


	@Override
	public String toString() {
		return super.toString() + this.getClass().getSimpleName() + "[" +
				"trust=" + trust + ", " + 
				"freeTransition=" + freeTransition + 
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
				this.freeTransition == other.freeTransition &&
				this.trust == other.trust;
	}

	@Override
	public Object clone() {
		CheckingAccount cloned = (CheckingAccount) super.clone(); 
		cloned.freeTransition = this.freeTransition;
		cloned.trust = this.trust;
		return cloned;
	}

	private double trust;
	private int freeTransition = 3;
}