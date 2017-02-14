package contobancario.bankaccounts;

import contobancario.exceptions.IllegalBankAccountException;

/**
 * The Class BankBook.
 *
 */
public class BankBook extends BankAccount implements Cloneable {
	
	/**
	 * Initialize a new BankBook.
	 * 
	 */
	public BankBook() {
		this.interest = 0;
	}
	
	/**
	 * Initialize a new BankBook with his interest.
	 * 
	 * @param interest the interest
	 */
	public BankBook(double interest) {
		this.interest = interest;
	}
	
	@Override
	public void withdraw(double amount) throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Illegal operation on BankBook");
	}
	
	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		throw new IllegalBankAccountException("Illegal operation on BankBook");
	}
	
	/**
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}

	/**
	 * @param interest the interest to set
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}

	/** 
	 * Return a string representation of the structure object.
	 * 
	 * @return string representation of the object
	 */
	@Override
	public String toString() {
		return "BankBook [interest=" + interest + "]";
	}

	/**
	 * Make a "deep" comparison between this object and another object.
	 * 
	 * @return true, if the comparated object have the same class and the same properties
	 */
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankBook other = (BankBook) obj;
		return
				this.interest == other.interest;
	}
	
	/**
	 * Make a "deep" copy of this object.
	 * 
	 * @return cloned, the clone of this object
	 */
	@Override
	public Object clone() {
		BankBook cloned = (BankBook) super.clone(); 
		cloned.interest = this.interest;
		return cloned;
	}

	private double interest;
	
}
