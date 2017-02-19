package contobancario.main;

import java.util.GregorianCalendar;

import contobancario.bankaccounts.BankAccount;
import contobancario.bankaccounts.BankBook;
import contobancario.bankaccounts.CheckingAccount;
import contobancario.bankaccounts.DebitCard;
import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;
import contobancario.model.Transition;

public class Main {
	public static void main(String[] args) throws IllegalBankAccountException {
		ClientRecord client = new ClientRecord("Giorgo", "DiGiorgio", new GregorianCalendar(1996, 5, 4), "Napoli");
		
		CheckingAccount chka1 = new CheckingAccount(client, 1500, "ABC123456789123456");
		BankBook bnkb1 = new BankBook(client, 2000, "DEF123456789123456", 0.5);
		
		DebitCard dbtc1 = new DebitCard(client, "GHI321654987321654", chka1);
		DebitCard dbtc2 = new DebitCard(client, "LMN123456789321654", bnkb1);
		
		//Transition trn1 = new Transition(dbtc1, 500, new GregorianCalendar());
		//trn1.run("add");
		
		//Transition trn2 = new Transition(dbtc2, 2000, new GregorianCalendar());
		//trn2.run("withdraw");
		
		System.out.println(bnkb1);
		System.out.println(dbtc2);
		//System.out.println(trn1);
	}
}
