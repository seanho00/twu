/**
 * Show the contents of an array as a histogram, using Swing.
 * 
 * @author Sean Ho
 * @studentid 314159
 * @course CMPT 166
 */

// any imports go here
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Display an array of ints as a histogram
 */
public class Histogram extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    /**
     * Schedule a job for the event-dispatching thread:
     * creating and showing this application's GUI.
     * 
     * @param args
     *            Command-line arguments
     */
    public static void main(final String args[]) {
        // This is the thread-safe way to initialize the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Histogram();
            }
        });
    }

    // Constant: How many bins
    public final int            NUMBINS = 12;

    // The array we're displaying
    private final int           array[];
    // GUI widgets
    private JProgressBar        bars[];
    private JLabel              labels[];
    private JFormattedTextField newEntry;
    private JToggleButton       autoRun;

    private JButton             sort;

    // Timer to auto-generate entries
    private final Timer         timer;

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
        for (int i = 0; i < NUMBINS; i++) {
            array[i] = 0;
        }

        // Setup the autorun timer
        timer = new Timer(10, this); // milliseconds

        // Refresh the progress bars
        updateDisplay();

        // Setup JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // or use setSize(w,h)
        setVisible(true);
    }

    /**
     * The master event handler
     * 
     * @param evt
     *            The event that triggered this handler
     */
    @Override
    public void actionPerformed(final ActionEvent evt) {
        final Object src = evt.getSource();

        if (src == newEntry) { // Manually entered number
            final int val = ((Number) newEntry.getValue()).intValue();
            if ((val >= 0) && (val <= NUMBINS - 1)) {
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
            final double rand = Math.random();
            final int val = (int) (rand * rand * NUMBINS);
            array[val]++;
            updateDisplay();
        }
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

    /* Create each widget in the UI and lay them out */
    private void createWidgets() {

        // Emulate look-and-feel of current OS
        try {
            UIManager.setLookAndFeel(UIManager
                    .getSystemLookAndFeelClassName());
        } catch (final UnsupportedLookAndFeelException e) {} catch (final ClassNotFoundException e) {} catch (final InstantiationException e) {} catch (final IllegalAccessException e) {}

        // Input field to manually add a number
        final NumberFormat intFormat = NumberFormat.getIntegerInstance();
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
            labels[i] = new JLabel(Integer.toString(i),
                    SwingConstants.RIGHT);
            labels[i].setLabelFor(bars[i]);
        }
    }

    // Layout the widgets in the panel
    private void layoutWidgets() {
        setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
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
    private void swap(final int i, final int j) {
        final int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * Refresh the histogram bar display
     */
    private void updateDisplay() {
        int max = 20;
        for (int i = 0; i < NUMBINS; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        for (int i = 0; i < NUMBINS; i++) {
            bars[i].setValue(array[i]);
            bars[i].setMaximum(max);
            labels[i].setText(i + ": " + array[i]);
        }
    }
}
