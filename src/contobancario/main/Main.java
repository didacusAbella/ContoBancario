package contobancario.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import contobancario.exceptions.IllegalBankAccountException;
import contobancario.gui.LoginFrame;
import contobancario.gui.OperatorFrame;
import contobancario.utils.Generator;

/**
 * The class Main.
 *
 */
public class Main {

	public static void main(String[] args) throws IllegalBankAccountException, FileNotFoundException, IOException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Generator generator = new Generator();
			LoginFrame login = new LoginFrame(generator);
		} catch (ClassNotFoundException e) {
			System.err.println("Class Error:" + e);
		} catch (InstantiationException e) {
			System.err.println("Installation Error:" + e);
		} catch (IllegalAccessException e) {
			System.err.println("Illegal access!" + e);
		} catch (UnsupportedLookAndFeelException e) {
			System.err.println("Look and Feel Not Supported!" + e);
		}
	}
}
