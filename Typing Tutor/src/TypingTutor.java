import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class TypingTutor {

	private JFrame frmTypingTutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypingTutor window = new TypingTutor();
					window.frmTypingTutor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TypingTutor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTypingTutor = new JFrame();
		frmTypingTutor.setTitle("Typing Tutor");
		frmTypingTutor.setBounds(100, 100, 731, 495);
		frmTypingTutor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTypeSomeText = new JLabel("Type some Text using your keyboard. The keys you press will be highlighted and displayed.");
		lblTypeSomeText.setBounds(10, 11, 559, 15);
		lblTypeSomeText.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNoteClickingThe = new JLabel("Note: Clicking the buttons with your mouse will not perform any action.");
		lblNoteClickingThe.setBounds(10, 32, 445, 15);
		lblNoteClickingThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 58, 695, 193);
		ArrayList<JKeyboardButton> btns = new ArrayList<JKeyboardButton>();
		btns.add(new JKeyboardButton("`", 192));
		
		for(int i = 49 ; i < 58 ; i++) btns.add(new JKeyboardButton("" + (char) i));
		btns.add(new JKeyboardButton("0"));
		btns.add(new JKeyboardButton("-"));
		btns.add(new JKeyboardButton("+", 61));
		btns.add(new JKeyboardButton("Backspace", 8, JKeyboardButton.Size.LARGE));
		btns.add(new JKeyboardButton("Tab", 9, JKeyboardButton.Size.MEDIUM));
		btns.add(new JKeyboardButton("Q"));
		btns.add(new JKeyboardButton("W"));
		btns.add(new JKeyboardButton("E"));
		btns.add(new JKeyboardButton("R"));
		btns.add(new JKeyboardButton("T"));
		btns.add(new JKeyboardButton("Y"));
		btns.add(new JKeyboardButton("U"));
		btns.add(new JKeyboardButton("I"));
		btns.add(new JKeyboardButton("O"));
		btns.add(new JKeyboardButton("P"));
		btns.add(new JKeyboardButton("["));
		btns.add(new JKeyboardButton("]"));
		btns.add(new JKeyboardButton("\\"));
		btns.add(new JKeyboardButton("Caps", 20, JKeyboardButton.Size.MEDIUM));
		btns.add(new JKeyboardButton("A"));
		btns.add(new JKeyboardButton("S"));
		btns.add(new JKeyboardButton("D"));
		btns.add(new JKeyboardButton("F"));
		btns.add(new JKeyboardButton("G"));
		btns.add(new JKeyboardButton("H"));
		btns.add(new JKeyboardButton("J"));
		btns.add(new JKeyboardButton("K"));
		btns.add(new JKeyboardButton("L"));
		btns.add(new JKeyboardButton(":"));
		btns.add(new JKeyboardButton("\""));
		btns.add(new JKeyboardButton("Enter", 10, JKeyboardButton.Size.LARGE));
		btns.add(new JKeyboardButton("Shift", 16, JKeyboardButton.Size.LARGE));
		btns.add(new JKeyboardButton("Z"));
		btns.add(new JKeyboardButton("X"));
		btns.add(new JKeyboardButton("C"));
		btns.add(new JKeyboardButton("V"));
		btns.add(new JKeyboardButton("B"));
		btns.add(new JKeyboardButton("N"));
		btns.add(new JKeyboardButton("M"));
		btns.add(new JKeyboardButton(","));
		btns.add(new JKeyboardButton("."));
		btns.add(new JKeyboardButton("?", 47));
		btns.add(new JKeyboardButton("", 32, JKeyboardButton.Size.SPACE));
		
		
		frmTypingTutor.getContentPane().setLayout(null);
		frmTypingTutor.getContentPane().add(textArea);
		frmTypingTutor.getContentPane().add(lblTypeSomeText);
		frmTypingTutor.getContentPane().add(lblNoteClickingThe);
		
		int currentX = 10;
		int currentY = 258;
		for (JKeyboardButton b : btns) {
			if(currentX + b.getButtonSize().getValue() > frmTypingTutor.getBounds().width) {
				currentX = 10;
				currentY += 36;
			}
			b.setBounds(currentX, currentY, b.getButtonSize().getValue(), 36);
			currentX = b.getBounds().x + b.getButtonSize().getValue();
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.printf("%s: %d\n", (char) b.getkeyKode(), b.getkeyKode());
				}
			});
			frmTypingTutor.getContentPane().add(b);
		}
		
		textArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			private void changeColor(KeyEvent e, boolean isPressed) {
				for(Component c : frmTypingTutor.getContentPane().getComponents())
					if(c.getClass() == JKeyboardButton.class && ((JKeyboardButton) c).getkeyKode() == e.getKeyCode()) {
						if(isPressed) {
							c.setBackground(Color.BLACK);
							c.setForeground(Color.WHITE);
						}
						else {
							c.setBackground(null);
							c.setForeground(null);
						}
					}				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				changeColor(e, false);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.printf("%s: %s code=%d\n", e.getKeyChar(), e.getKeyText(e.getKeyCode()) , e.getKeyCode());
				changeColor(e, true);
			}
		});
	}
}
