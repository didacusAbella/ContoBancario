package contobancario.bankaccounts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

public class CreditCard extends BankAccount implements Cloneable {
	
	public CreditCard(){
	}
	
	public CreditCard(ClientRecord client, double balance, String iban,GregorianCalendar dateOfIssue){
		super(client,balance,iban);

	}
	
	public void withdraw(double amount,GregorianCalendar DateOfIssue) throws IllegalBankAccountException{
		dateOfIssue=DateOfIssue;
		dateOfIssueMonth=DateOfIssue;
		
		year=dateOfIssue.get(Calendar.YEAR);
		month=dateOfIssue.get(Calendar.MONTH)+1;
		day=dateOfIssue.get(Calendar.DATE);
		
		year=dateOfIssueMonth.get(Calendar.YEAR);
		month=dateOfIssueMonth.get(Calendar.MONTH)+2;
		day=dateOfIssueMonth.get(Calendar.DATE);
		
		if(DateOfIssue.before(dateOfIssueMonth))
			
		if(amount>=plafond || DateOfIssue.before(dateOfIssueMonth))
			throw new IllegalBankAccountException("Can not withdraw illegal ammount");
		super.balance-=amount;
		
	}	
	
	@Override
	public void deposit(double amount) throws IllegalBankAccountException {
		super.balance+=amount;
	}
	
	public double getPlafond() {
		return plafond;
	}

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
	
	private GregorianCalendar dateOfIssue;
	private GregorianCalendar dateOfIssueMonth;
	private int year,month,day;
	private double plafond=2000;
}