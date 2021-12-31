import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.Box;

/* TODO: Key combination to stop clicking. 
			Offset click times by random value.

			Allow modify order of mouse points.

			Add a min/max delay spinner for the
			time randomization options.
*/


public class Graphics extends JFrame implements ActionListener{

	JButton setButton = new JButton("Set");
	JButton clearButton = new JButton("Clear");
	JToggleButton runButton = new JToggleButton("Run/stop");
	JButton exitButton = new JButton("Exit");

	JLabel spinnerLabel = new JLabel("Set Delay: ");
	SpinnerModel spinModel = new SpinnerNumberModel(3,0,10,1);
	JSpinner spinner = new JSpinner(spinModel);

	JLabel runSpinnerLabel = new JLabel("Run Delay: ");
	SpinnerModel runSpinModel = new SpinnerNumberModel(5,1,60,1);
	JSpinner runSpinner = new JSpinner(runSpinModel);

	JCheckBox randomClicksCheckBox = new JCheckBox("Randomize clicks");	
	JCheckBox randomTimeCheckBox = new JCheckBox("Randomize Time");	
	JCheckBox clickMoveCheckBox = new JCheckBox("Click/Move");	

	String[] points = new String[0];

	JList<String> list = new JList<>(points);

	Mouse mouse = new Mouse();
	Manager manager = new Manager(); 

	Mechanism mechanism;

	boolean stop = false;

	public Graphics() {
		super("Frame Title");	
		setSize(450 ,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setLayout(new BorderLayout());

		JPanel pane = new JPanel();
		JPanel textPane = new JPanel(new BorderLayout());
		JPanel checkPane = new JPanel();
		JPanel spinPane = new JPanel();
		JPanel runSpinPane = new JPanel();

		textPane.setBorder(new EmptyBorder(10,10,10,10));
		checkPane.setBorder(new EmptyBorder(10,10,10,10));
		spinPane.setBorder(new EmptyBorder(100,160,10,10));
		runSpinPane.setBorder(new EmptyBorder(10,160,10,10));
		pane.setBorder(new EmptyBorder(10,10,10,10));

		// Keep the spinner from streching the width of the panel.
		Box box = Box.createVerticalBox();
		spinner.setMaximumSize(new Dimension(35,30));
		randomTimeCheckBox.setMaximumSize(new Dimension(250,25));
		
		checkPane.setLayout(new BoxLayout(checkPane, BoxLayout.Y_AXIS));

		spinPane.add(spinnerLabel);
		spinPane.add(spinner);
		runSpinPane.add(runSpinnerLabel);
		runSpinPane.add(runSpinner);
		checkPane.add(randomTimeCheckBox);
		checkPane.add(randomClicksCheckBox);
		checkPane.add(clickMoveCheckBox);
		//checkPane.add(spinnerLabel);
		//box.add(this.spinner);
		//checkPane.add(box);
		checkPane.add(spinPane);
		checkPane.add(runSpinPane);
	
		list.setVisibleRowCount(8);		
		JScrollPane scroll = new JScrollPane(this.list);

		scroll.setPreferredSize(new Dimension(250,150));

		textPane.add(scroll, BorderLayout.WEST);
		textPane.add(checkPane, BorderLayout.EAST);

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

	void modifyList() {
		this.points = manager.getList();
		this.list.setListData(this.points);
		this.list.updateUI();
	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == setButton) {
			int delay = (Integer)this.spinner.getValue();
			try {
				Thread.sleep(delay * 1000);
			} catch (Exception e) {
				System.out.println("Set Delay Fail");
			}
			manager.add(this.mouse.getCurrentMouse());
			this.modifyList();
			manager.debug();
		}
		else if (source == clearButton) {
			this.list.getSelectedIndex();
			manager.delete(this.list.getSelectedIndex());
			this.modifyList();
		}
		else if (source == runButton) {
			if (this.stop == false) {
				int delay = (Integer)this.runSpinner.getValue();
				mechanism = new Mechanism(manager, mouse,
											delay, false);
				mechanism.start();
				this.stop = true;
				System.out.println("Stop activated.");
			} else {
				mechanism.end();
				this.stop = false;
				System.out.println("Stop deactivated.");
			}
		}
		else if (source == exitButton) {
			System.exit(0);
		}
	}
} 
