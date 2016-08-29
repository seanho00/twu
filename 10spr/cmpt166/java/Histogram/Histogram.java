/**
 * Show the contents of an array as a histogram, using Swing.
 *
 * @author Sean Ho
 * @studentid 314159
 * @course CMPT 166
 */

// any imports go here
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.*;

/**
 * Display an array of ints as a histogram
 */
public class Histogram extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	// Constant: How many bins
	public final int NUMBINS = 12;

	// The array we're displaying
	private int array[];

	// GUI widgets
	private JProgressBar bars[];
	private JLabel labels[];
	private JFormattedTextField newEntry;
	private JToggleButton autoRun;
	private JButton sort;

	// Timer to auto-generate entries
	private Timer timer;

	/**
	 * Create a new Histogram window
	 */
	Histogram() {
		super("Histogram");

		// Setup the widgets
		createWidgets();
		layoutWidgets();

		// Initialize the array
		array = new int[NUMBINS];
		for (int i = 0; i < NUMBINS; i++)
			array[i] = 0;

		// Setup the autorun timer
		timer = new Timer(10, this); // milliseconds
		timer.addActionListener(this);

		// Refresh the progress bars
		updateDisplay();

		// Setup JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();			// or use setSize(w,h)
		setVisible(true);
	}

	/* Create each widget in the UI and lay them out */
	private void createWidgets() {

		// Input field to manually add a number
		NumberFormat intFormat = NumberFormat.getIntegerInstance();
		intFormat.setMaximumIntegerDigits(2);

		newEntry = new JFormattedTextField(intFormat);
		newEntry.setColumns(2);
		newEntry.setValue(0);
		newEntry.addActionListener(this);

		// Buttons
		autoRun = new JToggleButton("Auto-generate");
		autoRun.addActionListener(this);

		sort = new JButton("Sort array");
		sort.addActionListener(this);

		// Labels and progress bars for the histogram
		bars = new JProgressBar[NUMBINS];
		labels = new JLabel[NUMBINS];

		for (int i = 0; i < NUMBINS; i++) {
			bars[i] = new JProgressBar(0, 10);
			labels[i] = new JLabel(Integer.toString(i), JLabel.RIGHT);
			labels[i].setLabelFor(bars[i]);
		}
	}

	// Layout the widgets in the panel
	private void layoutWidgets() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.ipadx = c.ipady = 5;

		for (int i = 0; i < NUMBINS; i++) {
			c.gridy = i + 1;

			c.gridx = 1;
			add(labels[i], c);
			c.gridx = 2;
			add(bars[i], c);
		}

		c.gridx = 0;

		c.gridy = NUMBINS / 2;
		add(newEntry, c);

		c.gridheight = 2;

		c.gridy = NUMBINS / 2 + 1;
		add(autoRun, c);
		c.gridy = NUMBINS / 2 + 3;
		add(sort, c);

		pack(); // auto-fit size of frame
	}

	/**
	 * Helper function: swap elements of the array
	 * 
	 * @param i
	 *            index of element to swap
	 * @param j
	 *            index of element to swap
	 */
	private void swap(int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/**
	 * Sort the array: bubble sort
	 */
	public void bubbleSort() {
		for (int pass = 1; pass < array.length; pass++) {
			for (int idx = 0; idx < array.length - 1; idx++) {
				if (array[idx] > array[idx + 1]) {
					swap(idx, idx + 1);
				}
			}
		}
	}

	/**
	 * Sort the array: selection sort
	 */
	public void selectionSort() {
		for (int cur = 0; cur < array.length - 1; cur++) {
			int min = array[cur];
			int minidx = cur;

			for (int idx = cur + 1; idx < array.length; idx++) {
				if (array[idx] < min) {
					min = array[idx];
					minidx = idx;
				}
			}

			swap(cur, minidx);
		}
	}

	/**
	 * Refresh the histogram bar display
	 */
	private void updateDisplay() {
		int max = 20;
		for (int i = 0; i < NUMBINS; i++)
			if (array[i] > max)
				max = array[i];

		for (int i = 0; i < NUMBINS; i++) {
			bars[i].setValue(array[i]);
			bars[i].setMaximum(max);
			labels[i].setText(i + ": " + array[i]);
		}
	}

	/**
	 * The master event handler
	 * 
	 * @param evt
	 *            The event that triggered this handler
	 */
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();

		if (src == newEntry) { // Manually entered number
			int val = ((Number) newEntry.getValue()).intValue();
			if (val >= 0 && val <= NUMBINS - 1) {
				array[val]++;
				updateDisplay();
			}
			newEntry.selectAll();

		} else if (src == autoRun) { // Toggle autorun
			if (autoRun.isSelected()) {
				timer.start();
			} else {
				timer.stop();
			}

		} else if (src == sort) { // Trigger sort
			selectionSort();
			updateDisplay();

		} else if (src == timer) { // Autorun timer event
			double rand = Math.random();
			int val = (int) (rand * rand * NUMBINS);
			array[val]++;
			updateDisplay();
		}
	}

	/**
	 * Schedule a job for the event-dispatching thread: creating and showing
	 * this application's GUI.
	 * 
	 * @param args
	 *            Command-line arguments
	 */
	public static void main(String args[]) {
		// This is the thread-safe way to initialize the GUI
		Runnable doRun = new Runnable() {
			public void run() {
				new Histogram();
			}
		};
		SwingUtilities.invokeLater(doRun);
	}
}
