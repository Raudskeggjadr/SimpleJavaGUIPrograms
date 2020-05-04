import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SigsCalcWindow extends JFrame {
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public SigsCalcWindow() {
		
		super("Welcome to Sig's Calculator - Java Edition!");
		
		setLayout(new GridBagLayout());
		
		JTextField numbersField = new JTextField("0", 50);
		Font f = new Font("Helvetica", Font.PLAIN, 56);
		numbersField.setForeground(Color.ORANGE);
		numbersField.setBackground(Color.BLACK);
		numbersField.setFont(f);
		numbersField.setHorizontalAlignment(JTextField.RIGHT);
		numbersField.setEditable(false);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		add(numbersField, gbc);
		
		JButton button1 = new JButton("1");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button1, gbc);
		JButton button2 = new JButton("2");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button2, gbc);
		JButton button3 = new JButton("3");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button3, gbc);
		JButton button4 = new JButton("4");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button4, gbc);
		JButton button5 = new JButton("5");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button5, gbc);
		JButton button6 = new JButton("6");
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button6, gbc);
		JButton button7 = new JButton("7");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button7, gbc);
		JButton button8 = new JButton("8");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button8, gbc);
		JButton button9 = new JButton("9");
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button9, gbc);
		JButton button0 = new JButton("0");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button0, gbc);
		JButton buttonDot = new JButton(".");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonDot, gbc);
		JButton buttonPlus = new JButton("+");
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonPlus, gbc);
		JButton buttonMinus = new JButton("-");
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonMinus, gbc);
		JButton buttonMultiplication = new JButton("*");
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonMultiplication, gbc);
		JButton buttonDivision = new JButton("/");
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonDivision, gbc);
		JButton buttonEquals = new JButton("=");
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonEquals, gbc);
		
	}
	
}