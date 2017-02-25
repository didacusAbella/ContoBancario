package contobancario.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.gui.LoginFrame;
import contobancario.gui.OperatorFrame;
import contobancario.utils.Generator;

public class Main {
	public static void main(String[] args) throws IllegalBankAccountException {
		
		Generator generator = new Generator();
		
		//LoginFrame login = new LoginFrame(generator);
		OperatorFrame operator = new OperatorFrame(generator);
		
		
	
	}
}
