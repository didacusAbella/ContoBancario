package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

public class CreditCard extends BankAccount {

	public CreditCard() {
		super();
		this.credit = 0;
	}

	public CreditCard(ClientRecord client, double balance, String iban, double creditPlafond) throws IllegalBankAccountException {
		super(client, balance, iban);
		CREDIT_PLAFOND = creditPlafond;
		this.credit = CREDIT_PLAFOND;
	}

	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Can not deposit on a credit card!");
	}

	@Override
	public void withdraw(double amount) throws IllegalBankAccountException {
		if (amount > this.credit)
			throw new IllegalBankAccountException("Illegal amount!");
		this.credit -= amount;
	}

	@Override
	public void interest() throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Illegal operation!");
	}

	@Override
	public void charge() throws IllegalBankAccountException {
		super.balance -= (CREDIT_PLAFOND - this.credit);
		if (super.balance < 0)
			super.balance -= FIXED_CHARGE;
	}

	@Override
	public void plafond(double plafond) throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Illegal operation!");
	}

	@Override
	public String toString() {
		return super.toString() + "[" + 
				"credit" + this.credit + 
				"]";
	}

	@Override
	public boolean equals(Object obj){
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		return 
				this.credit == other.credit;
	}

	@Override
	public Object clone() {
		CreditCard cloned = (CreditCard) super.clone(); 
		cloned.credit = this.credit;
		return cloned;
	}

	private static double CREDIT_PLAFOND;
	private static double FIXED_CHARGE = 2;

	private double credit;
}