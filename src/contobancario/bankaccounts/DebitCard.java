package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

/**
 * The class DebitCard.
 *
 */
public class DebitCard extends BankAccount  {

	/**
	 * Instantiates a new DebitCard.
	 * 
	 */
	public DebitCard() {
		super();
		this.account = null;
	}

	/**
	 * Instantiates a new DebitCard.
	 * 
	 * @param client the client
	 * @param iban the iban
	 * @param account the account
	 * @throws IllegalBankAccountException
	 */
	public DebitCard(ClientRecord client, String iban, BankAccount account) throws IllegalBankAccountException {
		super(client, 0, iban);
		if (account instanceof CheckingAccount || account instanceof BankBook)
			this.account = account;
		else
			throw new IllegalBankAccountException("A DebitCard can only be connected to a CheckingAccount or BankBook!");
	}

	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		this.account.deposit(amount);
	}

	@Override
	public void withdraw(double amount) throws IllegalBankAccountException {
		this.account.withdraw(amount);
	}

	@Override
	public void interest() throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Illegal operation!");
	}

	@Override
	public void charge() throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Illegal operation!");
	}

	@Override
	public void plafond(double plafond) throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Illegal operation!");
	}

	@Override
	public String toFormat() {
		return super.toFormat() +
				"\t\t" + "acc: " + this.account.getIban();
	}

	/**
	 * Gets the account.
	 * 
	 * @return the account.
	 */
	public BankAccount getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 * 
	 * @param account the account
	 */
	public void setAccount(BankAccount account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return super.toString() + "[" + 
				"account=" + account +
				"]";
	}

	@Override
	public boolean equals(Object obj){
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DebitCard other = (DebitCard) obj;
		return
				this.account.equals(other.account);
	}

	@Override
	public Object clone() {
		DebitCard cloned = (DebitCard) super.clone(); 
		cloned.account = (BankAccount) this.account.clone();
		return cloned;
	}

	private BankAccount account;
}
