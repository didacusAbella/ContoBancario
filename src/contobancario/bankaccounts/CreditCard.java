package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

public class CreditCard extends BankAccount implements Cloneable {
	/**
	 * 
	 */
	public CreditCard()
	{}
	
	public CreditCard(ClientRecord client, double balance, String iban){
		super(client,balance,iban);
	}
	
	public void withdraw(double amount) throws IllegalBankAccountException{
		if(amount>=plafond)
			throw new IllegalBankAccountException("Can not withdraw illegal ammount");
		super.balance-=amount;
	}	
	
	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		super.balance+=amount;
	}
	
	/** 
	 * @return the plafond
	 */
	public double getPlafond() {
		return plafond;
	}

	/**
	 * @param plafond the plafond to set
	 */
	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}

	
	@Override
	public String toString() {
		return super.toString()+this.getClass().getSimpleName() + "[" + 
				", Plafond=" + this.plafond+ 
				"]";
	}


	
	@Override
	public boolean equals(Object obj){
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		return this.plafond==other.plafond;
	}

	@Override
	public Object clone() {
		CreditCard cloned = (CreditCard) super.clone(); 
		cloned.plafond = this.plafond;
		return cloned;
	}
	
	private double plafond=2000;
}