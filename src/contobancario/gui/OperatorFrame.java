package contobancario.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import contobancario.utils.Generator;

import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import java.awt.image.renderable.RenderableImageOp;

public class OperatorFrame extends JFrame {
	public OperatorFrame(Generator generator) {
		this.generator = generator;
		initialize();
	}
	
	private void initialize() {
		this.setTitle("Operatore");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.setSize(520, 500);
		
		JMenuBar menuBar = new JMenuBar();
		this.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem item1 = new JMenuItem("Logout");
		menuFile.add(item1);
		
		JMenuItem item2 = new JMenuItem("Exit");
		menuFile.add(item2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
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
		
		JButton btnNewButton = new JButton("Conti");
		buttonsPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Operatori");
		buttonsPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clienti");
		buttonsPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Transazioni");
		buttonsPanel.add(btnNewButton_3);
		
		JPanel transitionsPanel = new JPanel();
		tabbedPane.addTab("Transitions", null, transitionsPanel, null);
		transitionsPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		transitionsPanel.add(topPanel, BorderLayout.NORTH);
		
		JRadioButton moveRadio = new JRadioButton("Move");
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
		
		JPanel panel_1 = new JPanel();
		transitionsPanel.add(panel_1, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		transitionsPanel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton executeButton = new JButton("Execute");
		bottomPanel.add(executeButton);
		
		this.setVisible(true);
	}
	
	private final Generator generator;
}
