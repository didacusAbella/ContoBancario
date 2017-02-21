package contobancario.utils;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import contobancario.bankaccounts.BankAccount;
import contobancario.bankaccounts.BankBook;
import contobancario.bankaccounts.CheckingAccount;
import contobancario.bankaccounts.CreditCard;
import contobancario.bankaccounts.DebitCard;
import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;
import contobancario.model.Operator;

/**
 * The class Generator
 *
 */
public class Generator {
	
	/**
	 * Instantiates a new Generator.
	 * @throws IllegalBankAccountException 
	 */
	public Generator() throws IllegalBankAccountException {
		generateOperator();
		generateBankAccout();
	}
	
	private void generateOperator() {
		Operator operator1 = new Operator("DIAV93", "admin");
		Operator operator2 = new Operator("ANPA93", "admin");
		
		this.operators.add(operator1);
		this.operators.add(operator2);
	}
	
	private void generateBankAccout() throws IllegalBankAccountException {
		ClientRecord client1 = new ClientRecord("Antonio", "Terrano", new GregorianCalendar(1997, 1, 22), "Angri");
		ClientRecord client2 = new ClientRecord("Macco", "Ferraioli", new GregorianCalendar(1993,  5, 25), "Scafati");
		ClientRecord client3 = new ClientRecord("Francesca", "Nappi", new GregorianCalendar(1996, 8, 2), "Sant'Egidio del Monte Albino");
		
		CheckingAccount checkingAccount1 = new CheckingAccount(client1, 5000, "ABC123456789");
		CheckingAccount checkingAccount2 = new CheckingAccount(client2, 200, "DEF987654321");
		CheckingAccount checkingAccount3 = new CheckingAccount(client3, 10000, "GHI789456123");
		
		BankBook bankBook1 = new BankBook(client1, 800, "ABC445566778", 0.3);
		BankBook bankBook2 = new BankBook(client2, 400, "DEF7788996655", 0.5);
		BankBook bankBook3 = new BankBook(client3, 7000, "GHI321654987", 0.5);
		
		CreditCard creditCard1 = new CreditCard(client1, 6000, "ABC321654987", 1000);
		CreditCard creditCard2 = new CreditCard(client2, 2000, "DEF456789123", 500);
		CreditCard creditCard3 = new CreditCard(client3, 8000, "GHI123654789", 2000);
		
		DebitCard debitCard1 = new DebitCard(client1, "ABC112233445", checkingAccount1);
		DebitCard debitCard2 = new DebitCard(client2, "DEF789456123", checkingAccount2);
		DebitCard debitCard3 = new DebitCard(client3, "GHI998877665", bankBook3);
		
		this.bankAccountks.add(checkingAccount1);
		this.bankAccountks.add(checkingAccount2);
		this.bankAccountks.add(checkingAccount3);
		this.bankAccountks.add(bankBook1);
		this.bankAccountks.add(bankBook2);
		this.bankAccountks.add(bankBook3);
		this.bankAccountks.add(creditCard1);
		this.bankAccountks.add(creditCard2);
		this.bankAccountks.add(creditCard3);
		this.bankAccountks.add(debitCard1);
		this.bankAccountks.add(debitCard2);
		this.bankAccountks.add(debitCard3);
	}
	
	/**
	 * @return the bankAccountks
	 */
	public ArrayList<BankAccount> getBankAccountks() {
		return bankAccountks;
	}

	/**
	 * @param bankAccountks the bankAccountks to set
	 */
	public void setBankAccountks(ArrayList<BankAccount> bankAccountks) {
		this.bankAccountks = bankAccountks;
	}

	/**
	 * @return the operators
	 */
	public ArrayList<Operator> getOperators() {
		return operators;
	}

	/**
	 * @param operators the operators to set
	 */
	public void setOperators(ArrayList<Operator> operators) {
		this.operators = operators;
	}

	private ArrayList<BankAccount> bankAccountks = new ArrayList<>();
	private ArrayList<Operator> operators = new ArrayList<>();
}
