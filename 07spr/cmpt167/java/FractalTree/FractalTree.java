/**
 * Fractal trees (L-systems) using Swing.
 *
 * @author Sean Ho
 * @studentid 314159
 * @course CMPT 167
 */

// any imports go here
import javax.swing.*;		// JPanel
import java.awt.*;		// Graphics
import java.awt.geom.*;		// AffineTransform

/**
 * Fractal trees (L-systems) using Swing.
 */
public class FractalTree extends JPanel {

   /**
    * Initialize GUI widgets and internal variables
    */
   FractalTree() {
   }

   /**
    * Redraw the window pane.
    * We use the Java2D API: {link:http://java.sun.com/docs/books/tutorial/2d/}
    * @param g Graphics context
    */
   public void paintComponent(Graphics g) {
     super.paintComponent(g);
     Graphics2D g2d = (Graphics2D) g;
     Dimension dim = getSize();

     AffineTransform origXform = g2d.getTransform();	// save old transform

     g2d.translate( dim.width/2, dim.height/2 );	// centre of window

     // Draw a hexagon
     for (int i=0; i<6; i++) {
       g2d.drawLine( 0, 0, 0, 50 );
       g2d.translate( 0, 50 );
       g2d.rotate( Math.toRadians(60) );		// 60 degrees
     }

     g2d.setTransform( origXform );			// restore original
   }

   /**
    * Set up the window and pane.
    */
   private static void createAndShowGUI() {
     // Set the look-and-feel to match the current system
     try {
       UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
     } catch (UnsupportedLookAndFeelException e) {
     } catch (ClassNotFoundException e) {
     } catch (InstantiationException e) {
     } catch (IllegalAccessException e) {
     }

     JFrame frame = new JFrame("Fractal Tree");	// create window
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     JPanel panel = new FractalTree();		// content pane
     panel.setOpaque(true);

     frame.setContentPane(panel);		// connect up and show
     frame.pack();
     frame.setSize( 300, 300 );			// window width, height
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
