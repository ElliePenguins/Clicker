import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/* TODO: Key combination to stop clicking. 
			Offset click times by random value. */

public class Graphics extends JFrame implements ActionListener{

	JButton setButton = new JButton("Set");
	JButton clearButton = new JButton("Clear");
	JButton runButton = new JButton("Run");

	Mouse m = new Mouse();

	public Graphics() {
		super("Frame Title");	
		setSize(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		JPanel pane = new JPanel();
		pane.add(this.setButton);
		pane.add(this.clearButton);
		pane.add(this.runButton);
		addActionListeners();
		add(pane);
		pack();
		setVisible(true);
	}

	public static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(
				"com.sun.java.swing.plaf.numbus.NmbusLookAndFeel"
			);
		} catch (Exception e) {
				System.out.println("Couldn't set look and feel.");
			}
	}

	void addActionListeners() {
		setButton.addActionListener(this);
		clearButton.addActionListener(this);
		runButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == setButton) {
			System.exit(0);
		}
		else if (source == clearButton) {
			System.exit(0);
		}
		else if (source == runButton) {
			System.exit(0);
		}
	}
	
} 
