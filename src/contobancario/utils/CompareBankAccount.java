package contobancario.utils;

import java.util.Comparator;

import contobancario.bankaccounts.BankAccount;

public class CompareBankAccount implements Comparator<BankAccount> {
	public int compare(BankAccount bankAccount1, BankAccount bankAccount2) {
		if (bankAccount1.getBalance() == bankAccount2.getBalance())
			return 0;

		if (bankAccount1.getBalance() < bankAccount2.getBalance())
			return -1;

		if (bankAccount1.getBalance() > bankAccount2.getBalance())
			return 1;

		return 0;
	}
}
