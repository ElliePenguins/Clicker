import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/* TODO: Key combination to stop clicking. 
			Offset click times by random value. */

public class Graphics extends JFrame implements ActionListener{

	JButton setButton = new JButton("Set");
	JButton clearButton = new JButton("Clear");
	JButton runButton = new JButton("Run");
	JButton exitButton = new JButton("Exit");
	
	String[] points = {"Default"};

	JList<String> list = new JList<>(points);

	Mouse mouse = new Mouse();
	Manager manager = new Manager(); 

	public Graphics() {
		super("Frame Title");	
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setLayout(new BorderLayout());

		JPanel pane = new JPanel();
		JPanel textPane = new JPanel();
		list.setVisibleRowCount(8);		
		JScrollPane scroll = new JScrollPane(this.list);

		textPane.add(scroll);

		pane.add(this.setButton);
		pane.add(this.clearButton);
		pane.add(this.runButton);
		pane.add(this.exitButton);
		addActionListeners();
		add(textPane ,BorderLayout.CENTER);
		add(pane, BorderLayout.SOUTH);
//		pack();
		setVisible(true);
	}

	public static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(
				"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
			);
		} catch (Exception e) {
				System.out.println("Couldn't set look and feel.");
			}
	}

	void addActionListeners() {
		setButton.addActionListener(this);
		clearButton.addActionListener(this);
		runButton.addActionListener(this);
		exitButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == setButton) {
			manager.add(this.mouse.getCurrentMouse());
			// TODO: CONTINUE HERE;
			manager.debug();
		}
		else if (source == clearButton) {
			// TODO: Get element to delete in UI.
			// TODO: CONTINUE HERE;
			manager.delete(0);
		}
		else if (source == runButton) {
			// TODO: Get element to delete in UI.
			// TODO: CONTINUE HERE;
			System.exit(0);
		}
		else if (source == exitButton) {
			System.exit(0);
		}
	}
	
} 
