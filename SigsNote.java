import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class SigsNote extends JFrame implements KeyListener, ActionListener {
	
	private static GridBagConstraints gbc = new GridBagConstraints();
	
	private static JTextArea textField;

	public SigsNote() {
		// TODO Auto-generated method stub
		
		//Window's title
		JFrame theFrame = new JFrame("Welcome to Sig's Notepad - Java Edition!");

        //Layout setting
		theFrame.setLayout(new GridBagLayout());

        //Drop down menus
        JMenuBar dropDownMenus = new JMenuBar();
        
        JMenu menu = new JMenu("File");
        JMenuItem itemopen = new JMenuItem("Open (WIP)");
        JMenuItem itemsave = new JMenuItem("Save (WIP)");
        JMenuItem itemsaveas = new JMenuItem("Save as... (WIP)");
        JMenuItem itemclose = new JMenuItem("Exit");
        menu.add(itemopen);
        menu.add(itemsave);
        menu.add(itemsaveas);
        menu.add(itemclose);
        dropDownMenus.add(menu);
        
        JMenu menu2 = new JMenu("Edit");
        JMenuItem itemsearch = new JMenuItem("Search (WIP)");
        JMenuItem itemcopy = new JMenuItem("Copy");
        JMenuItem itempaste = new JMenuItem("Paste");
        JMenuItem itemclear = new JMenuItem("Clear");
        menu2.add(itemsearch);
        menu2.add(itemcopy);
        menu2.add(itempaste);
        menu2.add(itemclear);
        dropDownMenus.add(menu2);
        
        JMenu menu3 = new JMenu("Help");
        JMenuItem itemhelp = new JMenuItem("Help (WIP)");
        JMenuItem itemabout = new JMenuItem("About (WIP)");
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
        
        itemsave.setBackground(Color.BLACK);
        itemsave.setForeground(Color.ORANGE);
        itemsave.setFont(ff);
        
        itemsaveas.setBackground(Color.BLACK);
        itemsaveas.setForeground(Color.ORANGE);
        itemsaveas.setFont(ff);
        
        itemclose.setBackground(Color.BLACK);
        itemclose.setForeground(Color.ORANGE);
        itemclose.setFont(ff);
        itemclose.addActionListener(this);
        
        itemsearch.setBackground(Color.BLACK);
        itemsearch.setForeground(Color.ORANGE);
        itemsearch.setFont(ff);
        
        itemcopy.setBackground(Color.BLACK);
        itemcopy.setForeground(Color.ORANGE);
        itemcopy.setFont(ff);
        itemcopy.addActionListener(this);
        
        itempaste.setBackground(Color.BLACK);
        itempaste.setForeground(Color.ORANGE);
        itempaste.setFont(ff);
        itempaste.addActionListener(this);
        
        itemclear.setBackground(Color.BLACK);
        itemclear.setForeground(Color.ORANGE);
        itemclear.setFont(ff);
        itemclear.addActionListener(this);
        
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
        theFrame.add(dropDownMenus, gbc);
        
        //Text field settings
        textField = new JTextArea();
        Font f = new Font("Helvetica", Font.PLAIN, 56);
        textField.setForeground(Color.ORANGE);
        textField.setBackground(Color.BLACK);
        textField.setFont(f);
        textField.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 3;
        gbc.weighty = 3;
        gbc.fill = GridBagConstraints.BOTH;
        theFrame.add(textField, gbc);
        
        theFrame.setSize(600, 300);  
        theFrame.setLocationRelativeTo(null);  
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        theFrame.setVisible(true);  

	}
	
	//Drop down menus functionality
	@Override
	public void actionPerformed (ActionEvent ee) {
		
		StringSelection copyThisToClipboard = new StringSelection(textField.getText());
		int textFieldLenght = textField.getText().length();
		
		switch (ee.getActionCommand()) {
		case "Exit":
			System.exit(0);
			break;
		case "Copy":
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copyThisToClipboard,
					copyThisToClipboard);
			break;
			//completely replaces old text instead of adding to it
		case "Paste":
			try {
				if (Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).isDataFlavorSupported(DataFlavor.stringFlavor))
					textField.append(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor).toString());
			}
			catch (UnsupportedFlavorException | IOException ex) {
				  System.out.println("Error while pasting from Clipboard - bad format");
			}
		case "Clear":
			textField.replaceRange("", 0, textFieldLenght);
			break;
		default:
			System.out.println("Unexpected (drop down menus)");
		}
		
	}
	
	//Key presses functionality
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		e.consume();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			textField.append("\n");
			e.consume();
			break;
		default:
			e.consume();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		e.consume();
	}

public static void main(String[] args) {
	
	new SigsNote();
	
}}