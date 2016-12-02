package ecg_irl;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelpFrame extends JFrame {

	public HelpFrame() throws HeadlessException {

	}

	public HelpFrame(String title) throws HeadlessException {
		super(title);
		JPanel HelpPanel = new HelpPanel();
		getContentPane().add(HelpPanel);
		pack();
		setVisible(false);
	}
}
