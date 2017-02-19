package contobancario.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import contobancario.model.Operator;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;


public class LoginFrame extends JFrame{
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setSize(400, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel menuPanel = new JPanel();
		getContentPane().add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem itemExit = new JMenuItem("Exit");
		menuFile.add(itemExit);
		menuPanel.add(menuBar);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel labelOperator = new JLabel("operator:");
		labelOperator.setBounds(90, 35, 70, 15);
		panel.add(labelOperator);
		
		JLabel labelPassword = new JLabel("password:");
		labelPassword.setBounds(90, 75, 80, 15);
		panel.add(labelPassword);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(180, 30, 140, 25);
		panel.add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 70, 140, 25);
		panel.add(passwordField);
		
		JButton button = new JButton("Login");
		button.setBounds(150, 125, 100, 25);
		panel.add(button);
		itemExit.addActionListener(new ExitListner());
		
		this.setVisible(true);
	}
	
	class ExitListner implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
	}
}
