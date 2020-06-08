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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SigsNote extends JFrame implements KeyListener, ActionListener {
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private JTextArea textField;

	public SigsNote() {
		// TODO Auto-generated method stub
		
		//Window's title
		JFrame theFrame = new JFrame("Welcome to Sig's Notepad - Java Edition!");

        //Layout setting
		theFrame.setLayout(new GridBagLayout());

        //Drop down menus
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
        itemopen.addActionListener(this);
        
        itemsave.setBackground(Color.BLACK);
        itemsave.setForeground(Color.ORANGE);
        itemsave.setFont(ff);
        
        itemsaveas.setBackground(Color.BLACK);
        itemsaveas.setForeground(Color.ORANGE);
        itemsaveas.setFont(ff);
        itemsaveas.addActionListener(this);
        
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
        itemhelp.addActionListener(this);
        
        itemabout.setBackground(Color.BLACK);
        itemabout.setForeground(Color.ORANGE);
        itemabout.setFont(ff);
        itemabout.addActionListener(this);
        
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
		JFrame saveOrOpenDialog = new JFrame();
		StringSelection copyThisToClipboard = new StringSelection(textField.getText());
		int textFieldLenght = textField.getText().length();
		UIManager.put("OptionPane.background", Color.DARK_GRAY);
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("OptionPane.messageForeground", Color.ORANGE);
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Button.foreground", Color.ORANGE);
		
		switch (ee.getActionCommand()) {
		  //Same problems as in SigsCalc
		  //----- SECURITY RISK ----- Possibility to open plain old text instead of numbers
		  case "Open":
			  JFileChooser openFile = new JFileChooser();
			  openFile.setDialogTitle("Open saved text file");
			  openFile.setDialogType(JFileChooser.OPEN_DIALOG);
			  openFile.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));
			  openFile.setCurrentDirectory(new File(System.getProperty("user.home") +
					  System.getProperty("file.separator") + "Desktop"));
			  if (openFile.showOpenDialog(saveOrOpenDialog) == JFileChooser.APPROVE_OPTION) {
				  try {
					  String data = ""; 
					  data = new String(Files.readAllBytes(Paths.get(openFile.getSelectedFile().getAbsolutePath()))); 
					  //Scanner ff = new Scanner(new File(openFile.getSelectedFile().getAbsolutePath()));
					  textField.append(data);
					  //ff.close();
				  } catch (Exception e) {
					  System.out.println("Error while opening a file.");
				  }
			  }
			  break;
			  
		  case "Save as...":
			  JFileChooser saveNewFile = new JFileChooser();
			  saveNewFile.setDialogTitle("Save Your Text To...");
			  saveNewFile.setDialogType(JFileChooser.SAVE_DIALOG);
			  saveNewFile.setSelectedFile(new File("Your Text.txt"));
			  saveNewFile.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));
			  saveNewFile.setCurrentDirectory(new File(System.getProperty("user.home") +
					  System.getProperty("file.separator") + "Desktop"));
			  if (saveNewFile.showSaveDialog(saveOrOpenDialog) == JFileChooser.APPROVE_OPTION) {
				  try { 
					  Formatter f = new Formatter(saveNewFile.getSelectedFile().getAbsolutePath());
					  f.format("%s", textField.getText());
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
		case "Help":
			JOptionPane.showMessageDialog(null, "This is a help screen.", "Help", JOptionPane.PLAIN_MESSAGE);
			break;
		case "About":
			JOptionPane.showMessageDialog(null, "Notepad created by Zygmunt Mocek.", "About", JOptionPane.PLAIN_MESSAGE);
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