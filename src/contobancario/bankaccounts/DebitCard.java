package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

public class DebitCard extends CreditCard implements Cloneable {
	
	public DebitCard(){
	}
	
	public DebitCard(ClientRecord client, double balance, String iban){
			super(client,balance,iban);
	}

	@Override
	public void withdraw(double amount) throws IllegalBankAccountException{
		if(amount>=maximumCredit)
			throw new IllegalBankAccountException("Can not withdraw illegal ammount");
		super.balance-=amount;
	}	
	
	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		super.balance+=amount;
	}
	
	/* 
	 * 
	 */
	@Override
	public String toString() {
		return super.toString()+this.getClass().getSimpleName() + "[" + 
				", Maximum Credit=" + this.maximumCredit+ 
				"]";
	}
	/*
	 * 
	 * 
	 */
	@Override
	public boolean equals(Object obj){
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DebitCard other = (DebitCard) obj;
		return this.maximumCredit==other.maximumCredit;
	}
	
	/*
	 * 
	 */
	@Override
	public Object clone() {
		DebitCard cloned = (DebitCard) super.clone(); 
		cloned.maximumCredit = this.maximumCredit;
		return cloned;
	}
	
	private double maximumCredit=-1000;
}