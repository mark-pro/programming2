import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class JKeyboardButton extends JButton {
	public enum Size {
		SMALL(46), MEDIUM(69), LARGE(92), SPACE(276);
		
		private final int value;
		
		private Size(int s) {
			value = s;
		}
		
		public int getValue() {
			return value;
		}
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 524878347518395728L;
	private int keyCode;
	private Size size;
	public JKeyboardButton(String text, int keyCode, Size size) {
		super(text);
		this.keyCode = keyCode;
		this.size = size;
	}
	public JKeyboardButton(String text, int keyCode) {
		super(text);
		this.keyCode = keyCode;
		this.size = Size.SMALL;
	}
	public JKeyboardButton(String text) {
		super(text);
		this.keyCode = KeyEvent.getExtendedKeyCodeForChar(text.toCharArray()[0]);
		this.size = Size.SMALL;
	}
	
	
	public Size getButtonSize() { return this.size; }
	public int getkeyKode() { return this.keyCode; }
}
