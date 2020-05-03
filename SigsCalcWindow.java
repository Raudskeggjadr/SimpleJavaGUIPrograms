import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SigsCalcWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField numbersField;
	
	public SigsCalcWindow() {
		
		super("Welcome to Sig's Calculator - Java Edition!");
		
		numbersField = new JTextField("0", 20);
		Font f = new Font("Helvetica", Font.PLAIN, 56);
		numbersField.setForeground(Color.ORANGE);
		numbersField.setBackground(Color.BLACK);
		numbersField.setFont(f);
		numbersField.setHorizontalAlignment(JTextField.RIGHT);
		numbersField.setEditable(false);
		add(numbersField);
		
	}
	
}