package listeners;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.JTextArea;

import parser.StringToURIParser;

public class JTextAreaListener implements KeyListener {

	private JTextArea ta;

	public JTextAreaListener(JTextArea ta) {
		ta.addKeyListener(this);
		this.ta = ta;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println("A key has been released");
		// System.out.println(e.getKeyCode());

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				URI uri = StringToURIParser
						.parseStringToGoogleRequestURI(this.ta.getText());
				if (uri != null) {
					Desktop.getDesktop().browse(uri);
				}
				this.ta.setText("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}