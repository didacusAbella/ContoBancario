package contobancario.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

import contobancario.model.Operator;
import contobancario.utils.Generator;

/**
 * The class LoginFrame.
 *
 */
public class LoginFrame extends JFrame{

	/**
	 * Instantiates a new LoginFrame.
	 * 
	 * @param generator the generator
	 */
	public LoginFrame(Generator generator) {
		this.generator = generator;
		initialize();
	}

	/**
	 * Builds the frame.
	 * 
	 */
	private void initialize() {
		this.setSize(400, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menubar
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuItem = new JMenuItem("Exit");
		menuFile.add(menuItem);
		menuItem.addActionListener(l -> System.exit(0));

		// Login Panel
		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel panel1 = new JPanel();
		mainPanel.add(panel1);

		JLabel label1 = new JLabel("Operator: ");
		panel1.add(label1);

		JComboBox<String> comboBox = new JComboBox<>();
		panel1.add(comboBox);

		for (Operator o: this.generator.getOperators()) 
			comboBox.addItem(o.getSerialNumber());

		JPanel panel2 = new JPanel();
		mainPanel.add(panel2);

		JLabel label2 = new JLabel("Password: ");
		panel2.add(label2);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setColumns(10);
		panel2.add(passwordField);

		JPanel panel3 = new JPanel();
		mainPanel.add(panel3);

		JButton buttonLogin = new JButton("Login");
		panel3.add(buttonLogin);

		buttonLogin.addActionListener(l -> {
			String insertPassword = new String(passwordField.getPassword());
			String password = null;

			for (Operator o: generator.getOperators()) {
				if (o.getSerialNumber().equals(comboBox.getSelectedItem().toString())){
					password = o.getPassword();
				}
			}

			if (insertPassword.equals(password)) {
				this.dispose();
				new OperatorFrame(this.generator);
			}
			else
				JOptionPane.showMessageDialog(null, "Incorrect password!");

		});

		this.setVisible(true);
	}

	private final Generator generator;
}
