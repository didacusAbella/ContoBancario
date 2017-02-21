package contobancario.main;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.gui.LoginFrame;
import contobancario.utils.Generator;

public class Main {
	public static void main(String[] args) throws IllegalBankAccountException {
		
		Generator generator = new Generator();
		
		LoginFrame login = new LoginFrame(generator);
	}
}
