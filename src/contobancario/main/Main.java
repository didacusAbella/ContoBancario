package contobancario.main;

import java.util.ArrayList;

import contobancario.bankaccounts.BankAccount;
import contobancario.exceptions.IllegalBankAccountException;
import contobancario.gui.LoginFrame;
import contobancario.gui.OperatorFrame;
import contobancario.utils.CompareBankAccount;
import contobancario.utils.Generator;

public class Main {
	public static void main(String[] args) throws IllegalBankAccountException {
		
		Generator generator = new Generator();
		
		//LoginFrame login = new LoginFrame(generator);
		//OperatorFrame operator = new OperatorFrame(generator);
		
		ArrayList<BankAccount> bankaccouts = generator.getBankAccountks();
		
		for (BankAccount b: bankaccouts) {
			System.out.println(b.getBalance());
		}
		
		System.out.println("~~~");
		
		bankaccouts.sort(new CompareBankAccount());
		
		for (BankAccount b: bankaccouts) {
			System.out.println(b.getBalance());
		}
	}
}
