package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

public class CheckingAccount extends BankAccount {

	public CheckingAccount() {
		super();
		this.plafond = 0;
		this.transitions = 0;
	}

	public CheckingAccount(ClientRecord client, double balance, String iban, double plafond) 
			throws IllegalBankAccountException {
		super(client, balance, iban);
		this.plafond = plafond;
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
		throw new IllegalBankAccountException("To a bank account can not be credited interests!");
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
		this.plafond = plafond;
	}
	
	public double getPlafond() {
		return plafond;
	}

	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}

	public int getTransitions() {
		return transitions;
	}

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
	
	private final int FREE_TRANSITIONS = 2;
	private final double FIXED_CHARGE = 1.50;
	private final double CHARGE = 0.50;
}
