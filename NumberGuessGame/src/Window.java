import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.security.SecureRandom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Window {

	private JFrame frame;
	private JTextField textField;
	private static int number;
	private JLabel lblCloseness;
	private char[] nums = new char[10];
	private int previousNumber = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		this.number = this.generateRandom();
		for(int i = 48; i < 58; i++)
			nums[i - 48] = KeyEvent.getKeyText(i).toCharArray()[0];
		
		for(char c : nums) System.out.println(c);
		initialize();
	}
	
	private int generateRandom() {
		SecureRandom r = new SecureRandom();
		int n = r.nextInt(999) + 1;
		System.out.printf("Random number obtained: %d\n", n);
		return n;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 267, 141);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if(new String(nums).contains(e.getKeyChar() + ""))
					System.out.printf("read key: %s -> %d\n", e.getKeyChar(), e.getKeyCode());
				else 
					e.consume();
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().length() > 0) {
					int i = Integer.parseInt(textField.getText());
					String txt = "";
					
					if(i > number)
						lblCloseness.setText("Too high");
					else if (i < number)
						lblCloseness.setText("Too low");
					else if(i == number) {
						lblCloseness.setText("Just right");
						int o = JOptionPane.showOptionDialog(frame, "You won, play again?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
								new Object[] { "Yes", "Exit" }, "Yes");
						
						System.out.println(o);
						
						if(o == JOptionPane.YES_OPTION) {
							reset();
							System.out.println("Continuing...");
						}
						else {
							System.out.println("Exiting program...");
							System.exit(0);
						}
					}
					
					if(Math.abs(number - i) < Math.abs(number - previousNumber))
						frame.getContentPane().setBackground(Color.RED);
					else
						frame.getContentPane().setBackground(Color.BLUE);
					
					previousNumber = i;
					
				}
				else {
					frame.getContentPane().setBackground(null);
					previousNumber = 0;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textField.setBounds(10, 57, 231, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrCanYouGuess = new JTextArea();
		txtrCanYouGuess.setText("Can you guess the number I am thinking of? It is between 1 and 1000.");
		txtrCanYouGuess.setBounds(10, 11, 231, 35);
		txtrCanYouGuess.setWrapStyleWord(true);
		txtrCanYouGuess.setLineWrap(true);
		txtrCanYouGuess.setEditable(false);
		txtrCanYouGuess.setFocusable(false);
		txtrCanYouGuess.setBackground(UIManager.getColor("Label.background"));
		txtrCanYouGuess.setFont(UIManager.getFont("Label.font"));
		txtrCanYouGuess.setBorder(UIManager.getBorder("Label.border"));
		
		frame.getContentPane().add(txtrCanYouGuess);
		
		lblCloseness = new JLabel("");
		lblCloseness.setBounds(10, 77, 115, 14);
		frame.getContentPane().add(lblCloseness);
	}
	
	private void reset() {
		previousNumber = 0;
		number = new SecureRandom().nextInt(999) + 1;
		System.out.printf("Random number obtained: %d\n", number);
		textField.setText("");
		lblCloseness.setText("");
		frame.getContentPane().setBackground(null);
	}
}
