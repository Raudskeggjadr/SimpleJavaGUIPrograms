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
    
    private JTextField numbersField;
    private StringBuilder initialNumberField = new StringBuilder();
    private StringBuilder additionalNumber = new StringBuilder();
    
    
    //Clear the number field method
    private void raze_it_to_the_ground() {
    	initialNumberField.replace(0, 50, "0");
		numbersField.setText(initialNumberField.toString());
    	}

    public SigsCalcWindow() {

        //Title of the window
        super("Welcome to Sig's Calculator - Java Edition!");
        
        //String builder responsible for the number field
        initialNumberField.append("0");

        //Layout setting
        setLayout(new GridBagLayout());

        //Drop down menus -----IN JAVA IT'S JUST CALLED MENU----- settings ----- THIS CODE IS ALSO TOO LONG
        JMenuBar dropDownMenus = new JMenuBar();
        MouseClass handler = new MouseClass();
        
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
        
        Font ff = new Font("Helvetica", Font.PLAIN, 18);
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
        
        itemopen.setBackground(Color.BLACK);
        itemopen.setForeground(Color.ORANGE);
        itemopen.setFont(ff);
        itemopen.addActionListener(new CloseMouseClass());
        
        itemsave.setBackground(Color.BLACK);
        itemsave.setForeground(Color.ORANGE);
        itemsave.setFont(ff);
        
        itemsaveas.setBackground(Color.BLACK);
        itemsaveas.setForeground(Color.ORANGE);
        itemsaveas.setFont(ff);
        itemsaveas.addActionListener(new CloseMouseClass());
        
        itemclose.setBackground(Color.BLACK);
        itemclose.setForeground(Color.ORANGE);
        itemclose.setFont(ff);
        itemclose.addActionListener(new CloseMouseClass());
        
        itemcopy.setBackground(Color.BLACK);
        itemcopy.setForeground(Color.ORANGE);
        itemcopy.setFont(ff);
        itemcopy.addActionListener(new CloseMouseClass());
        
        itempaste.setBackground(Color.BLACK);
        itempaste.setForeground(Color.ORANGE);
        itempaste.setFont(ff);
        itempaste.addActionListener(new CloseMouseClass());
        
        itemclear.setBackground(Color.BLACK);
        itemclear.setForeground(Color.ORANGE);
        itemclear.setFont(ff);
        itemclear.addActionListener(new CloseMouseClass());
        
        itemhelp.setBackground(Color.BLACK);
        itemhelp.setForeground(Color.ORANGE);
        itemhelp.setFont(ff);
        itemhelp.addActionListener(new CloseMouseClass());
        
        itemabout.setBackground(Color.BLACK);
        itemabout.setForeground(Color.ORANGE);
        itemabout.setFont(ff);
        itemabout.addActionListener(new CloseMouseClass());
        
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

    		if(o instanceof JButton)
    		   b = (JButton)o;
    			String buttonText = b.getText();
    		   
    		 switch(b.getText()) {
    		 case "+":
    			 initialNumberField.append(buttonText);
    			 additionalNumber.append(initialNumberField);
    			 raze_it_to_the_ground();
    			 System.out.println(additionalNumber.toString());
    			 break;
    		 case "-":
    			 initialNumberField.append(buttonText);
    			 additionalNumber.append(initialNumberField);
    			 raze_it_to_the_ground();
    			 System.out.println(additionalNumber.toString());
    			 break;
    		 case "*":
    			 initialNumberField.append(buttonText);
    			 additionalNumber.append(initialNumberField);
    			 raze_it_to_the_ground();
    			 System.out.println(additionalNumber.toString());
    			 break;
    		 case "/":
    			 initialNumberField.append(buttonText);
    			 additionalNumber.append(initialNumberField);
    			 raze_it_to_the_ground();
    			 System.out.println(additionalNumber.toString());
    			 break;
    		 case "=":
    			 initialNumberField.append(buttonText);
    			 additionalNumber.append(initialNumberField);
    			 raze_it_to_the_ground();
    			 System.out.println(additionalNumber.toString());
    			 break;
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
    			  try {
    				  Transferable copyThisFromClipboard = clipBoardContent.getContents(null);
    				  if (copyThisFromClipboard.isDataFlavorSupported(DataFlavor.stringFlavor))
    					  if (initialNumberField.toString().equals("0"))
    		    				initialNumberField.delete(0, 50);
    		    			initialNumberField.append(copyThisFromClipboard.getTransferData(DataFlavor.stringFlavor));
    		    			numbersField.setText(initialNumberField.toString());
    			  }
    				  catch (UnsupportedFlavorException | IOException ex) {
    					  System.out.println("Error while pasting from Clipboard");
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
    			  System.out.println("Unexpected (Buttons)");
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
			break;
		case KeyEvent.VK_1:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(1);
			numbersField.setText(initialNumberField.toString());
			break;
		case KeyEvent.VK_2:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(2);
			numbersField.setText(initialNumberField.toString());
			break;
		case KeyEvent.VK_3:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(3);
			numbersField.setText(initialNumberField.toString());
			break;
		case KeyEvent.VK_4:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(4);
			numbersField.setText(initialNumberField.toString());
			break;
		case KeyEvent.VK_5:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(5);
			numbersField.setText(initialNumberField.toString());
			break;
		case KeyEvent.VK_6:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(6);
			numbersField.setText(initialNumberField.toString());
			break;
		case KeyEvent.VK_7:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(7);
			numbersField.setText(initialNumberField.toString());
			break;
		case KeyEvent.VK_8:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(8);
			numbersField.setText(initialNumberField.toString());
			break;
		case KeyEvent.VK_9:
			if (initialNumberField.toString().equals("0"))
				initialNumberField.delete(0, 1);
			initialNumberField.append(9);
			numbersField.setText(initialNumberField.toString());
			break;
		default:
			System.out.println("Unexpexted (key presses)");
		}
		eee.consume();
	}

    @Override
	public void keyReleased(KeyEvent eee) {
		eee.consume();
	}
}
