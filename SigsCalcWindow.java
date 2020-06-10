import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Scanner;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;


public class SigsCalcWindow extends JFrame implements KeyListener {

    GridBagConstraints gbc = new GridBagConstraints();
    Font ff = new Font("Helvetica", Font.PLAIN, 18);
    Font f = new Font("Helvetica", Font.PLAIN, 56);
    
    private JTextField numbersField; //This is the value of the text field
    private StringBuilder initialNumberField = new StringBuilder(); //The first calculations number
    private StringBuilder additionalNumber = new StringBuilder("0"); //The second calculations number
    //Flags made to let the program know what calculation is to be made when pressing "Equals"
    private boolean isItAddition = false;
    private boolean isItSubstraction = false;
    private boolean isItMultiplacation = false;
    private boolean isItDivision = false;
    private MouseClass handler = new MouseClass();
    
    
    //Clear the number field method
    private void raze_it_to_the_ground() {
    	initialNumberField.replace(0, 50, "0");
		numbersField.setText(initialNumberField.toString());
    	}
    
    public void dropDownMenuClass(JMenuItem ddmItem) {
    	ddmItem.setBackground(Color.BLACK);
    	ddmItem.setForeground(Color.ORANGE);
    	ddmItem.setFont(ff);
    	ddmItem.addActionListener(new CloseMouseClass());
    }
    
    public void numberButtonsClass(JButton buttonitem, int a, int b, int c) {
    	buttonitem.setForeground(Color.ORANGE);
    	buttonitem.setBackground(Color.BLACK);
    	buttonitem.setFont(f);
        gbc.gridx = a;
        gbc.gridy = b;
        gbc.gridwidth = c;
        gbc.fill = GridBagConstraints.BOTH;
        add(buttonitem, gbc);
        buttonitem.addMouseListener(handler);
    }

    public SigsCalcWindow() {

        //Title of the window
        super("Welcome to Sig's Calculator - Java Edition!");
        
        //String builder responsible for the number field
        initialNumberField.append("0");

        //Layout setting
        setLayout(new GridBagLayout());

        //Drop down menus -----IN JAVA IT'S JUST CALLED MENU----- settings -----
        JMenuBar dropDownMenus = new JMenuBar();
        
        JMenu menu = new JMenu("File");
        JMenuItem itemopen = new JMenuItem("Open");
        JMenuItem itemsave = new JMenuItem("Save (WIP)");
        JMenuItem itemsaveas = new JMenuItem("Save as...");
        JMenuItem itemclose = new JMenuItem("Exit");
        menu.add(itemopen);
        menu.add(itemsave);
        menu.add(itemsaveas);
        menu.add(itemclose);
        dropDownMenus.add(menu);
        
        JMenu menu2 = new JMenu("Edit");
        JMenuItem itemcopy = new JMenuItem("Copy");
        JMenuItem itempaste = new JMenuItem("Paste");
        JMenuItem itemclear = new JMenuItem("Clear");
        menu2.add(itemcopy);
        menu2.add(itempaste);
        menu2.add(itemclear);
        dropDownMenus.add(menu2);
        
        JMenu menu3 = new JMenu("Help");
        JMenuItem itemhelp = new JMenuItem("Help");
        JMenuItem itemabout = new JMenuItem("About");
        menu3.add(itemhelp);
        menu3.add(itemabout);
        dropDownMenus.add(menu3);
        
        dropDownMenus.setBackground(Color.BLACK);
        menu.setForeground(Color.ORANGE);
        menu.setBackground(Color.BLACK);
        menu.setFont(ff);
        
        menu2.setForeground(Color.ORANGE);
        menu2.setBackground(Color.BLACK);
        menu2.setFont(ff);
        
        menu3.setForeground(Color.ORANGE);
        menu3.setBackground(Color.BLACK);
        menu3.setFont(ff);
        
        dropDownMenuClass(itemopen);
        dropDownMenuClass(itemsaveas);
        dropDownMenuClass(itemclose);
        dropDownMenuClass(itemcopy);
        dropDownMenuClass(itempaste);
        dropDownMenuClass(itemclear);
        dropDownMenuClass(itemhelp);
        dropDownMenuClass(itemabout);
        
        //Still a WIP
        itemsave.setBackground(Color.BLACK);
        itemsave.setForeground(Color.ORANGE);
        itemsave.setFont(ff);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(dropDownMenus, gbc);

        //Number field settings
        String numberShown = initialNumberField.toString();
        numbersField = new JTextField(numberShown, 50);
        numbersField.addKeyListener(this);
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

        //Number and equation buttons and their setting
        JButton button1 = new JButton("1");
        numberButtonsClass(button1, 0, 2, 1);
        
        JButton button2 = new JButton("2");
        numberButtonsClass(button2, 1, 2, 1);
        
        JButton button3 = new JButton("3");
        numberButtonsClass(button3, 2, 2, 1);
        
        JButton button4 = new JButton("4");
        numberButtonsClass(button4, 0, 3, 1);
        
        JButton button5 = new JButton("5");
        numberButtonsClass(button5, 1, 3, 1);
        
        JButton button6 = new JButton("6");
        numberButtonsClass(button6, 2, 3, 1);
        
        JButton button7 = new JButton("7");
        numberButtonsClass(button7, 0, 4, 1);
        
        JButton button8 = new JButton("8");
        numberButtonsClass(button8, 1, 4, 1);
        
        JButton button9 = new JButton("9");
        numberButtonsClass(button9, 2, 4, 1);
        
        JButton button0 = new JButton("0");
        numberButtonsClass(button0, 1, 5, 1);
        
        JButton buttonDot = new JButton(".");
        numberButtonsClass(buttonDot, 0, 5, 1);
        
        JButton buttonPlus = new JButton("+");
        numberButtonsClass(buttonPlus, 3, 2, 1);
        
        JButton buttonMinus = new JButton("-");
        numberButtonsClass(buttonMinus, 3, 3, 1);
        
        JButton buttonMultiplication = new JButton("*");
        numberButtonsClass(buttonMultiplication, 3, 4, 1);
        
        JButton buttonDivision = new JButton("/");
        numberButtonsClass(buttonDivision, 3, 5, 1);
        
        JButton buttonEquals = new JButton("=");
        numberButtonsClass(buttonEquals, 2, 5, 1);
        }

    //Buttons functionality
    private class MouseClass extends MouseAdapter{

		public void mouseClicked(MouseEvent event) {

    		Object o = event.getSource();
    		JButton b = null;
    		float firstNumber;
    		float secondNumber;
    		float theResult;

    		if(o instanceof JButton)
    		   b = (JButton)o;
    			String buttonText = b.getText();
    		   
    		// ----- COMPLEX CALCULATIONS WORK DIFFFERENTELY TO PYTHON EDITION, COMPERABLE TO WIN. CALC.
    		switch(b.getText()) {
    		 case "+":
    			 firstNumber = (Float.valueOf(additionalNumber.toString())).floatValue();
				 secondNumber = (Float.valueOf(initialNumberField.toString())).floatValue();
				 theResult = firstNumber+secondNumber;
    			 additionalNumber.replace(0, 50, Float.toString(theResult));
    			 raze_it_to_the_ground();
    			 System.out.println(additionalNumber);
    			 isItAddition = true;
    			 break;
    		 case "-":
				 firstNumber = (Float.valueOf(additionalNumber.toString())).floatValue();
				 secondNumber = (Float.valueOf(initialNumberField.toString())).floatValue();
				 theResult = firstNumber-secondNumber;
    			 additionalNumber.append(initialNumberField);
    			 raze_it_to_the_ground();
    			 System.out.println(additionalNumber);
    			 isItSubstraction = true;
    			 break;
    		 case "*":
				 firstNumber = (Float.valueOf(additionalNumber.toString())).floatValue();
				 secondNumber = (Float.valueOf(initialNumberField.toString())).floatValue();
				 theResult = firstNumber*secondNumber;
    			 additionalNumber.append(initialNumberField);
    			 raze_it_to_the_ground();
    			 System.out.println(additionalNumber);
    			 isItMultiplacation = true;
    			 break;
    		 case "/":
				 firstNumber = (Float.valueOf(additionalNumber.toString())).floatValue();
				 secondNumber = (Float.valueOf(initialNumberField.toString())).floatValue();
				 theResult = firstNumber/secondNumber;
    			 additionalNumber.append(initialNumberField);
    			 raze_it_to_the_ground();
    			 System.out.println(additionalNumber);
    			 isItDivision = true;
    			 break;
    		 case "=":
    			 if (isItAddition == true) {
    				 firstNumber = (Float.valueOf(additionalNumber.toString())).floatValue();
    				 secondNumber = (Float.valueOf(initialNumberField.toString())).floatValue();
    				 theResult = firstNumber+secondNumber;
        			 System.out.println(theResult);
        		     initialNumberField.replace(0, 50, Float.toString(theResult));
        			 numbersField.setText(initialNumberField.toString());
        			 additionalNumber.replace(0, 50, "0");
        			 isItAddition = false;
    			 } else if (isItSubstraction == true) {
    				 firstNumber = (Float.valueOf(additionalNumber.toString())).floatValue();
    				 secondNumber = (Float.valueOf(initialNumberField.toString())).floatValue();
    				 theResult = firstNumber-secondNumber;
        			 System.out.println(theResult);
        		     initialNumberField.replace(0, 50, Float.toString(theResult));
        			 numbersField.setText(initialNumberField.toString());
        			 additionalNumber.replace(0, 50, "0");
        			 isItSubstraction = false;
    			 } else if (isItMultiplacation == true) {
    				 firstNumber = (Float.valueOf(additionalNumber.toString())).floatValue();
    				 secondNumber = (Float.valueOf(initialNumberField.toString())).floatValue();
    				 theResult = firstNumber*secondNumber;
        			 System.out.println(theResult);
        		     initialNumberField.replace(0, 50, Float.toString(theResult));
        			 numbersField.setText(initialNumberField.toString());
        			 additionalNumber.replace(0, 50, "0");
        			 isItMultiplacation = false;
    			 } else if (isItDivision == true) {
    				 firstNumber = (Float.valueOf(additionalNumber.toString())).floatValue();
    				 secondNumber = (Float.valueOf(initialNumberField.toString())).floatValue();
    				 theResult = firstNumber/secondNumber;
        			 System.out.println(theResult);
        		     initialNumberField.replace(0, 50, Float.toString(theResult));
        			 numbersField.setText(initialNumberField.toString());
        			 additionalNumber.replace(0, 50, "0");
        			 isItDivision = false;
    			 } else {
        			 System.out.println("Problem with the result.");
    			 }
    			 break;
    		 //Not perfect but stops unnecessary dots
    		 case ".":
    			 if (initialNumberField.toString().contains(".")) {
    				 System.out.println("One dot is enough.");
    				 int theLenght = initialNumberField.toString().length();
    				 initialNumberField.delete(theLenght-1, theLenght);
    	    		 numbersField.setText(initialNumberField.toString());
    			 }
    		 default:
    			if (initialNumberField.toString().equals("0"))
    				initialNumberField.delete(0, 1);
    			initialNumberField.append(buttonText);
    			numbersField.setText(initialNumberField.toString());
}}}

    //Drop down menus functionality
    class CloseMouseClass implements ActionListener {
    	  public void actionPerformed(ActionEvent e) {
    		  JFrame saveOrOpenDialog = new JFrame();
    		  Clipboard clipBoardContent = Toolkit.getDefaultToolkit().getSystemClipboard();
    		  UIManager.put("OptionPane.background", Color.DARK_GRAY);
    		  UIManager.put("Panel.background", Color.BLACK);
    		  UIManager.put("OptionPane.messageForeground", Color.ORANGE);
    		  UIManager.put("Button.background", Color.BLACK);
    		  UIManager.put("Button.foreground", Color.ORANGE);
    		  switch (e.getActionCommand()) {
    		  //Path defaults to the desktop, gotta work on more exception, easy to crash the program
			  //----- SECURITY RISK ----- Possibility to open plain old text instead of numbers
    		  case "Open":
    			  JFileChooser openFile = new JFileChooser();
    			  openFile.setDialogTitle("Open a text file with your naumber");
    			  openFile.setDialogType(JFileChooser.OPEN_DIALOG);
    			  openFile.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));
    			  openFile.setCurrentDirectory(new File(System.getProperty("user.home") +
    					  System.getProperty("file.separator") + "Desktop"));
    			  if (openFile.showOpenDialog(saveOrOpenDialog) == JFileChooser.APPROVE_OPTION) {
    				  try { 
    					  Scanner ff = new Scanner(new File(openFile.getSelectedFile().getAbsolutePath()));
    					  initialNumberField.delete(0, 50);
    					  initialNumberField.append(ff.next());
    					  numbersField.setText(initialNumberField.toString());
    					  ff.close();
    				  } catch (Exception ee) {
    					  System.out.println("Error while opening a file.");
    				  }
    			  }
    			  break;
    			  
    		  case "Save as...":
    			  JFileChooser saveNewFile = new JFileChooser();
    			  saveNewFile.setDialogTitle("Save Your Number To...");
    			  saveNewFile.setDialogType(JFileChooser.SAVE_DIALOG);
    			  saveNewFile.setSelectedFile(new File("Your Numbers.txt"));
    			  saveNewFile.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));
    			  saveNewFile.setCurrentDirectory(new File(System.getProperty("user.home") +
    					  System.getProperty("file.separator") + "Desktop"));
    			  if (saveNewFile.showSaveDialog(saveOrOpenDialog) == JFileChooser.APPROVE_OPTION) {
    				  try { 
    					  Formatter f = new Formatter(saveNewFile.getSelectedFile().getAbsolutePath());
    					  f.format("%s", numbersField.getText());
    					  f.close();
    				  } catch (Exception eee) {
    					  System.out.println("Error while saving a file.");
    				  }
    			  }
    			  break;
    		  case "Exit":
    			  System.exit(0);
    			  break;
    		  case "Copy":
    			  StringSelection copyThisToClipBoard = new StringSelection(numbersField.getText());
    			  clipBoardContent.setContents(copyThisToClipBoard, copyThisToClipBoard);
    			  break;
    		  case "Paste":
    			  //----- SECURITY RISK ----- Possibility to paste plain old text instead of numbers
    			  try {
    				  Transferable copyThisFromClipboard = clipBoardContent.getContents(null);
    				  if (copyThisFromClipboard.isDataFlavorSupported(DataFlavor.stringFlavor))
    					  if (initialNumberField.toString().equals("0"))
    		    				initialNumberField.delete(0, 50);
    		    			initialNumberField.append(copyThisFromClipboard.getTransferData(DataFlavor.stringFlavor));
    		    			numbersField.setText(initialNumberField.toString());
    			  }
    				  catch (UnsupportedFlavorException | IOException ex) {
    					  System.out.println("Error while pasting from Clipboard - bad format");
    			  }
    			  break;
    		  case "Clear":
    			  raze_it_to_the_ground();
    			  break;
    		  case "Help":
    			  JOptionPane.showMessageDialog(null, "This is a help screen.", "Help", JOptionPane.PLAIN_MESSAGE);
    			  break;
    		  case "About":
    			  JOptionPane.showMessageDialog(null, "Calculator created by Zygmunt Mocek.", "About", JOptionPane.PLAIN_MESSAGE);
    			  break;
    		  default:
    			  System.out.println("Unexpected (drop down menus)");
    		  }
}}
    
    @Override
	public void keyTyped(KeyEvent eee) {
		eee.consume();
	}
    
    
    //Key presses functionality -----HAVE TO LOOK FOR A WAY TO STREAMLINE THIS -----
    @Override
	public void keyPressed(KeyEvent eee) {
		switch (eee.getKeyCode()) {
		case KeyEvent.VK_0:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(0);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD0:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(0);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_1:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(1);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD1:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(1);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_2:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(2);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD2:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(2);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_3:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(3);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD3:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(3);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_4:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(4);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD4:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(4);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_5:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(5);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD5:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(5);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_6:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(6);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD6:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(6);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_7:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(7);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD7:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(7);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_8:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(8);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD8:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(8);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_9:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(9);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		case KeyEvent.VK_NUMPAD9:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(9);
			numbersField.setText(initialNumberField.toString());
			eee.consume();
			break;
		default:
			System.out.println("Unexpexted (key presses)");
			eee.consume();
		}
	}

    @Override
	public void keyReleased(KeyEvent eee) {
		eee.consume();
	}
}