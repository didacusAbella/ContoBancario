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
import contobancario.model.Transition;

/**
 * The class Generator.
 *
 */
public class Generator {

	/**
	 * Instantiates a new Generator.
	 * 
	 * @throws IllegalBankAccountException 
	 */
	public Generator() throws IllegalBankAccountException {
		generateOperator();
		generateClientRecord();
		generateBankAccout();
	}
	
	/**
	 * Adds a transition.
	 * 
	 * @param transition the transition
	 */
	public void addTransition(Transition transition) {
		this.transitions.add(transition);
	}

	/**
	 * Generates the operators.
	 * 
	 */
	private void generateOperator() {
		Operator operator1 = new Operator("DI_AV-93", "admin");
		Operator operator2 = new Operator("AN_PA-93", "admin");
		Operator operator3 = new Operator("JO_RE-92", "admin");

		this.operators.add(operator1);
		this.operators.add(operator2);
		this.operators.add(operator3);
	}

	/**
	 * Generates the clients.
	 * 
	 */
	private void generateClientRecord() {
		ClientRecord client1 = new ClientRecord("Antonio", "Terrano", new GregorianCalendar(1997, 8, 18), "Angri");
		ClientRecord client2 = new ClientRecord("Macco", "Ferraioli", new GregorianCalendar(1997,  2, 25), "Angri");
		ClientRecord client3 = new ClientRecord("Francesca", "Nappi", new GregorianCalendar(1996, 7, 12), "Sant'Egidio");

		this.clientRecords.add(client1);
		this.clientRecords.add(client2);
		this.clientRecords.add(client3);
	}

	/**
	 * Generates the bankaccounts.
	 * 
	 * @throws IllegalBankAccountException
	 */
	private void generateBankAccout() throws IllegalBankAccountException {

		CheckingAccount checkingAccount1 = new CheckingAccount(clientRecords.get(0), 5000, "CH1111111111");
		CheckingAccount checkingAccount2 = new CheckingAccount(clientRecords.get(1), 1000, "CH2222222222");
		CheckingAccount checkingAccount3 = new CheckingAccount(clientRecords.get(2), 9000, "CH3333333333");

		BankBook bankBook1 = new BankBook(clientRecords.get(0), 800, "BB1111111111", 0.3);
		BankBook bankBook2 = new BankBook(clientRecords.get(1), 400, "BB2222222222", 0.5);
		BankBook bankBook3 = new BankBook(clientRecords.get(2), 700, "BB3333333333", 0.5);

		CreditCard creditCard1 = new CreditCard(clientRecords.get(0), 6000, "CC1111111111", 1000);
		CreditCard creditCard2 = new CreditCard(clientRecords.get(1), 2000, "CC2222222222", 500);
		CreditCard creditCard3 = new CreditCard(clientRecords.get(2), 8000, "CC3333333333", 2000);

		DebitCard debitCard1 = new DebitCard(clientRecords.get(0), "DC1111111111", checkingAccount1);
		DebitCard debitCard2 = new DebitCard(clientRecords.get(1), "DC2222222222", checkingAccount2);
		DebitCard debitCard3 = new DebitCard(clientRecords.get(2), "DC3333333333", bankBook3);

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
	 * Gets the bankaccounts.
	 * 
	 * @return the bankAccountks
	 */
	public ArrayList<BankAccount> getBankAccountks() {
		return bankAccountks;
	}

	/**
	 * Sets the bankaccounts.
	 * 
	 * @param bankAccountks the bankAccountks to set
	 */
	public void setBankAccountks(ArrayList<BankAccount> bankAccountks) {
		this.bankAccountks = bankAccountks;
	}

	/**
	 * Gets the operators.
	 * 
	 * @return the operators
	 */
	public ArrayList<Operator> getOperators() {
		return operators;
	}

	/**
	 * Sets the operators.
	 * 
	 * @param operators the operators to set
	 */
	public void setOperators(ArrayList<Operator> operators) {
		this.operators = operators;
	}

	/**
	 * Gets the clients.
	 * 
	 * @return the clientRecords
	 */
	public ArrayList<ClientRecord> getClientRecords() {
		return clientRecords;
	}

	/**
	 * Sets the clients.
	 * 
	 * @param clientRecords the clientRecords to set
	 */
	public void setClientRecords(ArrayList<ClientRecord> clientRecords) {
		this.clientRecords = clientRecords;
	}

	/**
	 * Gets the transitions.
	 * 
	 * @return the transitions
	 */
	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	/**
	 * Sets the transitions.
	 * 
	 * @param transitions the transitions to set
	 */
	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}

	private ArrayList<BankAccount> bankAccountks = new ArrayList<>();
	private ArrayList<Operator> operators = new ArrayList<>();
	private ArrayList<ClientRecord> clientRecords = new ArrayList<>();
	private ArrayList<Transition> transitions = new ArrayList<>();
}
