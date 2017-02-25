package contobancario.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.awt.BorderLayout;

import contobancario.bankaccounts.BankAccount;
import contobancario.bankaccounts.BankBook;
import contobancario.bankaccounts.CheckingAccount;
import contobancario.bankaccounts.CreditCard;
import contobancario.compare.CompareBankAccount;
import contobancario.compare.CompareClientRecord;
import contobancario.compare.CompareOperator;
import contobancario.compare.CompareTransitions;
import contobancario.exceptions.IllegalBankAccountException;
import contobancario.model.ClientRecord;
import contobancario.model.Operator;
import contobancario.model.Transition;
import contobancario.utils.Generator;

public class OperatorFrame extends JFrame {
	public OperatorFrame(Generator generator) {
		this.generator = generator;
		initialize();
	}

	private void initialize() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(670, 520);

		// Menu Bar
		JMenuBar menuBar = new JMenuBar();
		this.getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem item1 = new JMenuItem("Logout");
		menuFile.add(item1);

		JMenuItem item2 = new JMenuItem("Exit");
		menuFile.add(item2);
		item2.addActionListener(l -> System.exit(0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// Checking Panel
		JPanel checkingPanel = new JPanel();
		tabbedPane.addTab("Checking", null, checkingPanel, null);
		checkingPanel.setLayout(new BorderLayout(0, 0));

		JPanel textPanel = new JPanel();
		checkingPanel.add(textPanel, BorderLayout.CENTER);
		textPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JTextArea textArea = new JTextArea(50, 50);
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		textPanel.add(scrollPane);

		JPanel buttonsPanel = new JPanel();
		checkingPanel.add(buttonsPanel, BorderLayout.WEST);
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

		JButton bankAccountButton = new JButton("Bank Accounts");
		buttonsPanel.add(bankAccountButton);
		bankAccountButton.addActionListener(l -> {
			textArea.setText("");
			ArrayList<BankAccount> sortBankAccount = generator.getBankAccountks();
			sortBankAccount.sort(new CompareBankAccount());
			for (BankAccount b: sortBankAccount) 
				textArea.append(b.toFormat() + "\n");
		});

		JButton operatorsButton = new JButton("Operators");
		buttonsPanel.add(operatorsButton);
		operatorsButton.addActionListener(l -> {
			textArea.setText("");
			ArrayList<Operator> sortOperator = generator.getOperators();
			sortOperator.sort(new CompareOperator());
			for (Operator o: sortOperator)
				textArea.append(o.toFormat() + "\n");
		});

		JButton clientRecordsButton = new JButton("ClientRecords");
		buttonsPanel.add(clientRecordsButton);
		clientRecordsButton.addActionListener(l -> {
			textArea.setText("");
			ArrayList<ClientRecord> sortClientRecord = generator.getClientRecords();
			sortClientRecord.sort(new CompareClientRecord());
			for (ClientRecord c: sortClientRecord)
				textArea.append(c.toFormat() + "\n");
		});

		JButton transitionsButton = new JButton("Transitions");
		buttonsPanel.add(transitionsButton);
		transitionsButton.addActionListener(l -> {
			textArea.setText("");
			ArrayList<Transition> sortTransition = generator.getTransitions();
			sortTransition.sort(new CompareTransitions());
			for (Transition t: sortTransition)
				textArea.append(t.toString() + "\n");
		});

		// Transition Panel
		JPanel transitionsPanel = new JPanel();
		tabbedPane.addTab("Transitions", null, transitionsPanel, null);
		transitionsPanel.setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		transitionsPanel.add(topPanel, BorderLayout.NORTH);

		JRadioButton moveRadio = new JRadioButton("Move", true);
		topPanel.add(moveRadio);

		JRadioButton depositRadio = new JRadioButton("Deposit");
		topPanel.add(depositRadio);

		JRadioButton withdrawRadio = new JRadioButton("Withdraw");
		topPanel.add(withdrawRadio);

		JRadioButton interestRadio = new JRadioButton("Interest");
		topPanel.add(interestRadio);

		JRadioButton chargeRadio = new JRadioButton("Charge");
		topPanel.add(chargeRadio);

		JRadioButton plafondRadio = new JRadioButton("Plafond");
		topPanel.add(plafondRadio);

		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(moveRadio);
		radioGroup.add(depositRadio);
		radioGroup.add(withdrawRadio);
		radioGroup.add(interestRadio);
		radioGroup.add(chargeRadio);
		radioGroup.add(plafondRadio);

		JPanel bottomPanel = new JPanel();
		transitionsPanel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton executeButton = new JButton("Execute");
		bottomPanel.add(executeButton);

		// Central Panel
		JPanel centralPanel = new JPanel();
		transitionsPanel.add(centralPanel, BorderLayout.CENTER);

		// Move Panel
		JPanel movePanel = new JPanel();
		centralPanel.add(movePanel);
		movePanel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel topMovePanel = new JPanel();
		movePanel.add(topMovePanel);
		topMovePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel labelFrom = new JLabel("From: ");
		topMovePanel.add(labelFrom);

		JComboBox<String> frombkComboBox = new JComboBox<>();
		topMovePanel.add(frombkComboBox);

		for (BankAccount b: this.generator.getBankAccountks()) 
			frombkComboBox.addItem(b.getIban());

		JLabel labelTo = new JLabel("To: ");
		topMovePanel.add(labelTo);

		JComboBox<String> tobkComboBox = new JComboBox<>();
		topMovePanel.add(tobkComboBox);

		for (BankAccount b: this.generator.getBankAccountks()) 
			if (b instanceof CreditCard) {} // do nothing
			else
				tobkComboBox.addItem(b.getIban());

		JPanel bottomMovePanel = new JPanel();
		movePanel.add(bottomMovePanel);

		JLabel labelAmount1 = new JLabel("amount: ");
		bottomMovePanel.add(labelAmount1);

		JTextField amountTextField1 = new JTextField();
		amountTextField1.setColumns(10);
		bottomMovePanel.add(amountTextField1);

		JLabel valueLabel1 = new JLabel("€");
		bottomMovePanel.add(valueLabel1);

		// Deposit Panel
		JPanel depositPanel = new JPanel();
		depositPanel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel topDPanel = new JPanel();
		depositPanel.add(topDPanel);
		topDPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel bankAccountLabel1 = new JLabel("BankAccount: ");
		topDPanel.add(bankAccountLabel1);

		JComboBox<String> bankAccountComboBox1 = new JComboBox<>();
		topDPanel.add(bankAccountComboBox1);

		for (BankAccount b: this.generator.getBankAccountks()) 
			if (b instanceof CreditCard) {} // do nothing
			else 
				bankAccountComboBox1.addItem(b.getIban());

		JPanel bottomDPanel = new JPanel();
		depositPanel.add(bottomDPanel);

		JLabel labelAmount2 = new JLabel("amount: ");
		bottomDPanel.add(labelAmount2);

		JTextField amountTextField2 = new JTextField();
		amountTextField2.setColumns(10);
		bottomDPanel.add(amountTextField2);

		JLabel valueLabel2 = new JLabel("€");
		bottomDPanel.add(valueLabel2);

		// Withdraw Panel
		JPanel withdrowPanel = new JPanel();
		withdrowPanel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel topWPanel = new JPanel();
		withdrowPanel.add(topWPanel);
		topWPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel bankAccountLabel2 = new JLabel("BankAccount: ");
		topWPanel.add(bankAccountLabel2);

		JComboBox<String> bankAccountComboBox2 = new JComboBox<>();
		topWPanel.add(bankAccountComboBox2);

		for (BankAccount b: this.generator.getBankAccountks()) 
			bankAccountComboBox2.addItem(b.getIban());

		JPanel bottomWPanel = new JPanel();
		withdrowPanel.add(bottomWPanel);

		JLabel labelAmount3 = new JLabel("amount: ");
		bottomWPanel.add(labelAmount3);

		JTextField amountTextField3 = new JTextField();
		amountTextField3.setColumns(10);
		bottomWPanel.add(amountTextField3);

		JLabel valueLabel3 = new JLabel("€");
		bottomWPanel.add(valueLabel3);

		// Interest Panel
		JPanel interestPanel = new JPanel();

		JLabel bankAccountLabel3 = new JLabel("BankAccount: ");
		interestPanel.add(bankAccountLabel3);

		JComboBox<String> bankAccountComboBox3 = new JComboBox<>();
		interestPanel.add(bankAccountComboBox3);

		for (BankAccount b: this.generator.getBankAccountks()) {
			if (b instanceof BankBook)
				bankAccountComboBox3.addItem(b.getIban());
		}

		// Charge Panel
		JPanel chargePanel = new JPanel();

		JLabel bankAccountLabel4 = new JLabel("BankAccount: ");
		chargePanel.add(bankAccountLabel4);

		JComboBox<String> bankAccountComboBox4 = new JComboBox<>();
		chargePanel.add(bankAccountComboBox4);

		for (BankAccount b: this.generator.getBankAccountks()) 
			if (b instanceof CheckingAccount || b instanceof CreditCard)
				bankAccountComboBox4.addItem(b.getIban());

		// Plafond Panel
		JPanel plafontPanel = new JPanel();
		plafontPanel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel topPlafondPanel = new JPanel();
		plafontPanel.add(topPlafondPanel);
		topPlafondPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel bankAccountLabel5 = new JLabel("BankAccount: ");
		topPlafondPanel.add(bankAccountLabel5);

		JComboBox<String> bankAccountComboBox5 = new JComboBox<>();
		topPlafondPanel.add(bankAccountComboBox5);

		for (BankAccount b: this.generator.getBankAccountks()) {
			if (b instanceof CheckingAccount)
				bankAccountComboBox5.addItem(b.getIban());
		}

		JPanel bottomPlafondPanel = new JPanel();
		plafontPanel.add(bottomPlafondPanel);

		JLabel plafondLabel = new JLabel("plafond:");
		bottomPlafondPanel.add(plafondLabel);

		JTextField amountTextField4 = new JTextField();
		amountTextField4.setColumns(10);
		bottomPlafondPanel.add(amountTextField4);

		JLabel valueLabel4 = new JLabel("€");
		bottomPlafondPanel.add(valueLabel4);

		// Buttons Radio Listners
		moveRadio.addActionListener(l -> {
			centralPanel.removeAll();
			centralPanel.add(movePanel);
			centralPanel.revalidate();
			centralPanel.repaint();
		});

		depositRadio.addActionListener(l -> {
			centralPanel.removeAll();
			centralPanel.add(depositPanel);
			centralPanel.revalidate();
			centralPanel.repaint();
		});

		withdrawRadio.addActionListener(l -> {
			centralPanel.removeAll();
			centralPanel.add(withdrowPanel);
			centralPanel.revalidate();
			centralPanel.repaint();
		});

		interestRadio.addActionListener(l -> {
			centralPanel.removeAll();
			centralPanel.add(interestPanel);
			centralPanel.revalidate();
			centralPanel.repaint();
		});

		chargeRadio.addActionListener(l -> {
			centralPanel.removeAll();
			centralPanel.add(chargePanel);
			centralPanel.revalidate();
			centralPanel.repaint();
		});

		plafondRadio.addActionListener(l -> {
			centralPanel.removeAll();
			centralPanel.add(plafontPanel);
			centralPanel.revalidate();
			centralPanel.repaint();
		});

		// Execute Listner
		executeButton.addActionListener(l -> {
			if (moveRadio.isSelected()) {
				if (frombkComboBox.getSelectedItem().equals(tobkComboBox.getSelectedItem()))
					JOptionPane.showMessageDialog(null, "Invalid Operation!");

			}
			if (depositRadio.isSelected()) {
				for (BankAccount b: generator.getBankAccountks()) {
					if (bankAccountComboBox1.getSelectedItem().equals(b.getIban())) {
						Transition trn = new Transition(b, Double.parseDouble(amountTextField2.getText()), new GregorianCalendar());
						generator.addTransition(trn);
						try {
							trn.run("add");
						} catch (IllegalBankAccountException e) {
							e.printStackTrace();
						}
					}
				}

			}
			if (withdrawRadio.isSelected()) {
				for (BankAccount b: generator.getBankAccountks()) {
					if (bankAccountComboBox2.getSelectedItem().equals(b.getIban())) {
						Transition trn = new Transition(b, Double.parseDouble(amountTextField3.getText()), new GregorianCalendar());
						generator.addTransition(trn);
						try {
							trn.run("withdraw");
						} catch (IllegalBankAccountException e) {
							e.printStackTrace();
						}
					}
				}

			}
			if (interestRadio.isSelected()) {
				for (BankAccount b: generator.getBankAccountks()) {
					if (bankAccountComboBox3.getSelectedItem().equals(b.getIban())) {
						Transition trn = new Transition(b, new GregorianCalendar());
						generator.addTransition(trn);
						try {
							trn.run("interest");
						} catch (IllegalBankAccountException e) {
							e.printStackTrace();
						}
					}
				}
			}
			if (chargeRadio.isSelected()) {
				for (BankAccount b: generator.getBankAccountks()) {
					if (bankAccountComboBox4.getSelectedItem().equals(b.getIban())) {
						Transition trn = new Transition(b, new GregorianCalendar());
						generator.addTransition(trn);
						try {
							trn.run("charge");
						} catch (IllegalBankAccountException e) {
							e.printStackTrace();
						}
					}
				}
			}
			if (plafondRadio.isSelected()) {
				for (BankAccount b: generator.getBankAccountks()) {
					if (bankAccountComboBox5.getSelectedItem().equals(b.getIban())) {
						Transition trn = new Transition(b, Double.parseDouble(amountTextField4.getText()), new GregorianCalendar());
						generator.addTransition(trn);
						try {
							trn.run("plafond");
						} catch (IllegalBankAccountException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

		this.setVisible(true);
	}

	private Generator generator;
}
