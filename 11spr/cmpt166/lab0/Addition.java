/**
 * A simple applet that keeps a running total of numbers.
 *
 * This description text is in HTML format.
 *
 * @author Sean Ho
 * @studentid 314159
 * @course CMPT 167
 * @lab 0
 */

// any imports go here
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 * Addition is a small applet that keeps a running total of numbers.
 * 
 * Each class should have its own doc comment.
 */
public class Addition extends Applet implements ActionListener {
   Label prompt;      // message that prompts user to input
   TextField input;   // input values are entered here
   int number;        // variable that stores input value
   int sum;           // variable that stores sum of integers

   /**
    * Setup the graphical user interface components
    * and initialize variables.
    * Each method should have its own doc-comment with pre/post-conditions
    * (using @param and @return if necessary).
    */
   public void init()
   {
      prompt = new Label( "Enter integer and press Enter:" );
      add( prompt );  // put prompt widget on applet 

      input = new TextField( 10 );
      add( input );   // put input TextField widget on applet

      sum = 0;

      // "this" applet handles action events for the TextField input
      input.addActionListener( this );
   }

   /**
    * Process user's action in TextField input 
    * @param e The event of user pressing Enter in a TextField input widget
    */
   public void actionPerformed( ActionEvent e )
   {
      // get the number and convert it to an integer
      number = Integer.parseInt( e.getActionCommand() );

      sum += number;
      input.setText( "" );		// clear data entry field
      showStatus( Integer.toString( sum ) );  // display sum
   }
}
