package contobancario.main;

import java.util.GregorianCalendar;

import contobancario.bankaccounts.CheckingAccount;
import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;

public class Main {
	public static void main(String[] args) throws IllegalBankAccountException {
		ClientRecord client = new ClientRecord("Giorgo", "DiGiorgio",
				new GregorianCalendar(1996, 5, 4), "Napoli");
		CheckingAccount test = new CheckingAccount(client, 500, "BLA123456789123456", -2000);
		System.out.println(test);
	}
}
