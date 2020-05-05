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
		
		//Title of the window
		super("Welcome to Sig's Calculator - Java Edition!");
		
		//Layout setting
		setLayout(new GridBagLayout());
		
		//Number field settings
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
		
		//Number and equation buttens and ther setting ----- CODE IS TOO LONG -----
		JButton button1 = new JButton("1");
		button1.setForeground(Color.ORANGE);
		button1.setBackground(Color.BLACK);
		button1.setFont(f);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button1, gbc);
		JButton button2 = new JButton("2");
		button2.setForeground(Color.ORANGE);
		button2.setBackground(Color.BLACK);
		button2.setFont(f);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button2, gbc);
		JButton button3 = new JButton("3");
		button3.setForeground(Color.ORANGE);
		button3.setBackground(Color.BLACK);
		button3.setFont(f);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button3, gbc);
		JButton button4 = new JButton("4");
		button4.setForeground(Color.ORANGE);
		button4.setBackground(Color.BLACK);
		button4.setFont(f);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button4, gbc);
		JButton button5 = new JButton("5");
		button5.setForeground(Color.ORANGE);
		button5.setBackground(Color.BLACK);
		button5.setFont(f);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button5, gbc);
		JButton button6 = new JButton("6");
		button6.setForeground(Color.ORANGE);
		button6.setBackground(Color.BLACK);
		button6.setFont(f);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button6, gbc);
		JButton button7 = new JButton("7");
		button7.setForeground(Color.ORANGE);
		button7.setBackground(Color.BLACK);
		button7.setFont(f);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button7, gbc);
		JButton button8 = new JButton("8");
		button8.setForeground(Color.ORANGE);
		button8.setBackground(Color.BLACK);
		button8.setFont(f);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button8, gbc);
		JButton button9 = new JButton("9");
		button9.setForeground(Color.ORANGE);
		button9.setBackground(Color.BLACK);
		button9.setFont(f);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button9, gbc);
		JButton button0 = new JButton("0");
		button0.setForeground(Color.ORANGE);
		button0.setBackground(Color.BLACK);
		button0.setFont(f);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(button0, gbc);
		JButton buttonDot = new JButton(".");
		buttonDot.setForeground(Color.ORANGE);
		buttonDot.setBackground(Color.BLACK);
		buttonDot.setFont(f);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonDot, gbc);
		JButton buttonPlus = new JButton("+");
		buttonPlus.setForeground(Color.ORANGE);
		buttonPlus.setBackground(Color.BLACK);
		buttonPlus.setFont(f);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonPlus, gbc);
		JButton buttonMinus = new JButton("-");
		buttonMinus.setForeground(Color.ORANGE);
		buttonMinus.setBackground(Color.BLACK);
		buttonMinus.setFont(f);
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonMinus, gbc);
		JButton buttonMultiplication = new JButton("*");
		buttonMultiplication.setForeground(Color.ORANGE);
		buttonMultiplication.setBackground(Color.BLACK);
		buttonMultiplication.setFont(f);
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonMultiplication, gbc);
		JButton buttonDivision = new JButton("/");
		buttonDivision.setForeground(Color.ORANGE);
		buttonDivision.setBackground(Color.BLACK);
		buttonDivision.setFont(f);
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonDivision, gbc);
		JButton buttonEquals = new JButton("=");
		buttonEquals.setForeground(Color.ORANGE);
		buttonEquals.setBackground(Color.BLACK);
		buttonEquals.setFont(f);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(buttonEquals, gbc);
		
	}
	
}