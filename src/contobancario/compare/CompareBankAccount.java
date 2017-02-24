package contobancario.compare;

import java.util.Comparator;

import contobancario.bankaccounts.BankAccount;

public class CompareBankAccount implements Comparator<BankAccount> {
	public int compare(BankAccount bankAccount1, BankAccount bankAccount2) {
		if (bankAccount1.getBalance() == bankAccount2.getBalance())
			return 0;
		else if (bankAccount1.getBalance() < bankAccount2.getBalance())
			return -1;
		else
			return 1;
	}
}
