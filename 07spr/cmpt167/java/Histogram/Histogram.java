/**
 * Show the contents of an array as a histogram, using Swing.
 *
 * @author Sean Ho
 * @studentid 314159
 * @course CMPT 167
 */

// any imports go here
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.*;
import java.beans.*;

/**
 * Show an array as a histogram
 */
public class Histogram extends JPanel implements ActionListener
{

  // Constant: How many bins
  public final int SIZE = 10;

  // The array we're displaying
  private int array[];

  // GUI widgets
  private JProgressBar bars[];
  private JLabel labels[];
  private JFormattedTextField newEntry;
  private JToggleButton autoRun;
  private JButton sort;
  private NumberFormat intFormat;

  // Timer autogenerates entries
  private Timer timer;

   /**
    * Initialize GUI widgets and internal variables
    */
   Histogram() {

     // Initialize the widgets
     
     intFormat = NumberFormat.getIntegerInstance();
     intFormat.setMaximumIntegerDigits(2);

     newEntry = new JFormattedTextField(intFormat);
     newEntry.setColumns(2);
     newEntry.setValue(0);
     newEntry.addActionListener(this);

     autoRun = new JToggleButton("Auto-generate");
     autoRun.addActionListener(this);

     sort = new JButton("Sort array");
     sort.addActionListener(this);

     array = new int[SIZE];
     bars = new JProgressBar[SIZE];
     labels = new JLabel[SIZE];

     for (int i=0; i<SIZE; i++) 
     {
       array[i] = 0;
       bars[i] = new JProgressBar(0, 10);
       labels[i] = new JLabel(Integer.toString(i), JLabel.RIGHT);
       labels[i].setLabelFor(bars[i]);
     }

     // Layout the widgets in the panel
     this.setLayout(new GridBagLayout());
     GridBagConstraints c = new GridBagConstraints();
     c.ipadx = c.ipady = 5;

     for (int i=0; i<SIZE; i++)
     {
       c.gridx = 1;
       c.gridy = i+1;
       add(labels[i], c);

       c.gridx = 2;
       c.gridy = i+1;
       add(bars[i], c);
     }

     c.gridx = 0;
     c.gridy = SIZE/2;
     add(newEntry, c);

     c.gridy = SIZE/2 + 1;
     c.gridheight = 2;
     add(autoRun, c);

     c.gridy = SIZE/2 + 3;
     add(sort, c);

     // Setup the autorun timer
     timer = new Timer(10, this);	// milliseconds
     timer.addActionListener(this);

     // Refresh the bars
     updateDisplay();
   }

   /**
    * Helper function: swap elements of the array
    * @param i index of element to swap
    * @param j index of element to swap
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
     for (int pass=1; pass < array.length; pass++) {
       for (int idx=0; idx < array.length-1; idx++) {
	 if (array[idx] > array[idx+1]) {
	   swap(idx, idx+1);
	 }
       }
     }
   }

   /**
    * Sort the array: selection sort
    */
   public void selectionSort() {
     for (int cur=0; cur < array.length-1; cur++) {
       int min = array[cur];
       int minidx = cur;

       for (int idx=cur+1; idx < array.length; idx++) {
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
     for (int i=0; i<SIZE; i++) 
       if (array[i] > max) max = array[i];
     
     for (int i=0; i<SIZE; i++) 
     {
       bars[i].setValue(array[i]);
       bars[i].setMaximum(max);
       labels[i].setText(i + ": " + array[i]);
     }
   }

   /**
    * The master event handler
    * @param evt The event that triggered this handler
    */
   public void actionPerformed(ActionEvent evt) {
     int val;
     Object src = evt.getSource();

     if (src == newEntry) {			// Manually entered number
       val = ((Number) newEntry.getValue()).intValue();
       if (val >= 0 && val <= SIZE-1) {
	 array[val]++;
	 this.updateDisplay();
       }
       newEntry.selectAll();

     } else if (src == autoRun) {		// Toggle autorun
       if (autoRun.isSelected()) {
	 timer.start();
       } else {
	 timer.stop();
       }

     } else if (src == sort) {			// Trigger sort
       selectionSort();
       this.updateDisplay();

     } else if (src == timer) {			// Autorun timer event
       double rand = Math.random();
       val = (int) (rand * rand * SIZE);
       array[val]++;
       this.updateDisplay();
     }
   }

   /**
    * Set up the window and pane.
    */
   private static void createAndShowGUI() {
     JFrame frame = new JFrame("Histogram");	// create window
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     JPanel panel = new Histogram();		// content pane
     panel.setOpaque(true);

     frame.setContentPane(panel);		// connect up and show
     frame.pack();
     frame.setVisible(true);
   }

   /**
    * Schedule a job for the event-dispatching thread:
    * creating and showing this application's GUI.
    * @param args Command-line arguments
    */
   public static void main( String args[] ) {
     // This is the thread-safe way to initialize the GUI
     Runnable doRun = new Runnable() {
       public void run() { createAndShowGUI(); }
     };
     javax.swing.SwingUtilities.invokeLater( doRun );
   }
}
