import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class SigsCalcWindow extends JFrame{

    GridBagConstraints gbc = new GridBagConstraints();
    
    private JTextField numbersField;
    private JMenuItem itemclose;
    
    //Clear the number field method
    private int raze_it_to_the_ground() {
    	numbersField.setText("0");
    	return 0;
    	}

    public SigsCalcWindow() {

        //Title of the window
        super("Welcome to Sig's Calculator - Java Edition!");

        //Layout setting
        setLayout(new GridBagLayout());

        //Drop down menu -----IN JAVA IT'S JUST CALLED MENU----- settings ----- THIS CODE IS ALSO TOO LONG
        JMenuBar dropDownMenu = new JMenuBar();
        MouseClass handler = new MouseClass();
        
        JMenu menu = new JMenu("File");
        JMenuItem itemopen = new JMenuItem("Open (WIP)");
        JMenuItem itemsave = new JMenuItem("Save (WIP)");
        JMenuItem itemsaveas = new JMenuItem("Save as... (WIP)");
        itemclose = new JMenuItem("Exit");
        menu.add(itemopen);
        menu.add(itemsave);
        menu.add(itemsaveas);
        menu.add(itemclose);
        dropDownMenu.add(menu);
        
        JMenu menu2 = new JMenu("Edit");
        JMenuItem itemcopy = new JMenuItem("Copy (WIP)");
        JMenuItem itempaste = new JMenuItem("Paste (WIP)");
        JMenuItem itemclear = new JMenuItem("Clear");
        menu2.add(itemcopy);
        menu2.add(itempaste);
        menu2.add(itemclear);
        dropDownMenu.add(menu2);
        
        JMenu menu3 = new JMenu("Help");
        JMenuItem itemhelp = new JMenuItem("Help (WIP)");
        JMenuItem itemabout = new JMenuItem("About (WIP)");
        menu3.add(itemhelp);
        menu3.add(itemabout);
        dropDownMenu.add(menu3);
        
        Font ff = new Font("Helvetica", Font.PLAIN, 18);
        dropDownMenu.setBackground(Color.BLACK);
        menu.setForeground(Color.ORANGE);
        menu.setBackground(Color.BLACK);
        menu.setFont(ff);
        
        menu2.setForeground(Color.ORANGE);
        menu2.setBackground(Color.BLACK);
        menu2.setFont(ff);
        
        menu3.setForeground(Color.ORANGE);
        menu3.setBackground(Color.BLACK);
        menu3.setFont(ff);
        
        itemopen.setBackground(Color.BLACK);
        itemopen.setForeground(Color.ORANGE);
        itemopen.setFont(ff);
        
        itemsave.setBackground(Color.BLACK);
        itemsave.setForeground(Color.ORANGE);
        itemsave.setFont(ff);
        
        itemsaveas.setBackground(Color.BLACK);
        itemsaveas.setForeground(Color.ORANGE);
        itemsaveas.setFont(ff);
        
        itemclose.setBackground(Color.BLACK);
        itemclose.setForeground(Color.ORANGE);
        itemclose.setFont(ff);
        itemclose.addActionListener(new CloseMouseClass());
        
        itemcopy.setBackground(Color.BLACK);
        itemcopy.setForeground(Color.ORANGE);
        itemcopy.setFont(ff);
        
        itempaste.setBackground(Color.BLACK);
        itempaste.setForeground(Color.ORANGE);
        itempaste.setFont(ff);
        
        itemclear.setBackground(Color.BLACK);
        itemclear.setForeground(Color.ORANGE);
        itemclear.setFont(ff);
        itemclear.addActionListener(new CloseMouseClass());
        
        itemhelp.setBackground(Color.BLACK);
        itemhelp.setForeground(Color.ORANGE);
        itemhelp.setFont(ff);
        
        itemabout.setBackground(Color.BLACK);
        itemabout.setForeground(Color.ORANGE);
        itemabout.setFont(ff);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(dropDownMenu, gbc);

        //Number field settings
        numbersField = new JTextField("0", 50);
        Font f = new Font("Helvetica", Font.PLAIN, 56);
        numbersField.setForeground(Color.ORANGE);
        numbersField.setBackground(Color.BLACK);
        numbersField.setFont(f);
        numbersField.setHorizontalAlignment(JTextField.RIGHT);
        numbersField.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(numbersField, gbc);

        //Number and equation buttons and their setting ----- CODE IS TOO LONG -----
        JButton button1 = new JButton("1");
        button1.setForeground(Color.ORANGE);
        button1.setBackground(Color.BLACK);
        button1.setFont(f);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button1, gbc);
        button1.addMouseListener(handler);

        JButton button2 = new JButton("2");
        button2.setForeground(Color.ORANGE);
        button2.setBackground(Color.BLACK);
        button2.setFont(f);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button2, gbc);
        button2.addMouseListener(handler);

        JButton button3 = new JButton("3");
        button3.setForeground(Color.ORANGE);
        button3.setBackground(Color.BLACK);
        button3.setFont(f);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button3, gbc);
        button3.addMouseListener(handler);

        JButton button4 = new JButton("4");
        button4.setForeground(Color.ORANGE);
        button4.setBackground(Color.BLACK);
        button4.setFont(f);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button4, gbc);
        button4.addMouseListener(handler);

        JButton button5 = new JButton("5");
        button5.setForeground(Color.ORANGE);
        button5.setBackground(Color.BLACK);
        button5.setFont(f);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button5, gbc);
        button5.addMouseListener(handler);

        JButton button6 = new JButton("6");
        button6.setForeground(Color.ORANGE);
        button6.setBackground(Color.BLACK);
        button6.setFont(f);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button6, gbc);
        button6.addMouseListener(handler);

        JButton button7 = new JButton("7");
        button7.setForeground(Color.ORANGE);
        button7.setBackground(Color.BLACK);
        button7.setFont(f);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button7, gbc);
        button7.addMouseListener(handler);

        JButton button8 = new JButton("8");
        button8.setForeground(Color.ORANGE);
        button8.setBackground(Color.BLACK);
        button8.setFont(f);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button8, gbc);
        button8.addMouseListener(handler);

        JButton button9 = new JButton("9");
        button9.setForeground(Color.ORANGE);
        button9.setBackground(Color.BLACK);
        button9.setFont(f);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button9, gbc);
        button9.addMouseListener(handler);

        JButton button0 = new JButton("0");
        button0.setForeground(Color.ORANGE);
        button0.setBackground(Color.BLACK);
        button0.setFont(f);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(button0, gbc);
        button0.addMouseListener(handler);

        JButton buttonDot = new JButton(".");
        buttonDot.setForeground(Color.ORANGE);
        buttonDot.setBackground(Color.BLACK);
        buttonDot.setFont(f);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonDot, gbc);
        buttonDot.addMouseListener(handler);

        JButton buttonPlus = new JButton("+");
        buttonPlus.setForeground(Color.ORANGE);
        buttonPlus.setBackground(Color.BLACK);
        buttonPlus.setFont(f);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonPlus, gbc);
        buttonPlus.addMouseListener(handler);

        JButton buttonMinus = new JButton("-");
        buttonMinus.setForeground(Color.ORANGE);
        buttonMinus.setBackground(Color.BLACK);
        buttonMinus.setFont(f);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonMinus, gbc);
        buttonMinus.addMouseListener(handler);

        JButton buttonMultiplication = new JButton("*");
        buttonMultiplication.setForeground(Color.ORANGE);
        buttonMultiplication.setBackground(Color.BLACK);
        buttonMultiplication.setFont(f);
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonMultiplication, gbc);
        buttonMultiplication.addMouseListener(handler);

        JButton buttonDivision = new JButton("/");
        buttonDivision.setForeground(Color.ORANGE);
        buttonDivision.setBackground(Color.BLACK);
        buttonDivision.setFont(f);
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonDivision, gbc);
        buttonDivision.addMouseListener(handler);

        JButton buttonEquals = new JButton("=");
        buttonEquals.setForeground(Color.ORANGE);
        buttonEquals.setBackground(Color.BLACK);
        buttonEquals.setFont(f);
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonEquals, gbc);
        buttonEquals.addMouseListener(handler);

    }

    //Buttons functionality
    private class MouseClass extends MouseAdapter{

    	public void mouseClicked(MouseEvent event) {

    		Object o = event.getSource();
    		JButton b = null;
    		String buttonText = "";

    		if(o instanceof JButton)
    		   b = (JButton)o;
    		   buttonText = b.getText();
    		   
    		 switch(b.getText()) {
    		 case "+":
    			 raze_it_to_the_ground();
    			 break;
    		 case "-":
    			 raze_it_to_the_ground();
    			 break;
    		 case "*":
    			 raze_it_to_the_ground();
    			 break;
    		 case "/":
    			 raze_it_to_the_ground();
    			 break;
    		 case "=":
    			 raze_it_to_the_ground();
    			 break;
    		default:
    			numbersField.setText(numbersField.getText() + buttonText);
    		 }
    			 

    		 
    	}
    }

    class CloseMouseClass implements ActionListener {
    	  public void actionPerformed(ActionEvent e) {
    		  switch (e.getActionCommand()) {
    		  case "Exit":
    			  System.exit(0);
    			  break;
    		  case "Clear":
    			  raze_it_to_the_ground();
    			  break;
    		  default:
    			  System.out.println("Unexpected");
    		  }
    	}}
}