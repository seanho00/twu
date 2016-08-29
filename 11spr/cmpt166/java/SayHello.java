/**
 * A very simple interactive "Hello, World!" Java program.
 *
 * @author Sean Ho
 * @studentid 314159
 * @course CMPT 166
 */

// any imports go here
import javax.swing.*;

/**
 * A very simple "Hello, World!" Java program.
 */
public class SayHello {

   /**
    * The main() method begins execution of the Java program.
    */
   public static void main( String args[] )
   {
     String name;	// The user's name
     String repeat;	// How many times to repeat (string input)
     int num_repeat;	// How many times to repeat (integer)
     String response;	// Our response to the user

     // Set the look-and-feel to match the current system
     try {
       UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
     } catch (UnsupportedLookAndFeelException e) {
     } catch (ClassNotFoundException e) {
     } catch (InstantiationException e) {
     } catch (IllegalAccessException e) {
     }

     // Ask the user for his/her name
     name = JOptionPane.showInputDialog(
	 "Hi there! What's your name?" );

     // Ask the user for a number
     repeat = JOptionPane.showInputDialog(
	 "On a scale of 1 to 10, how narcissistic are you?" );

     // Convert from a string to a number
     num_repeat = Integer.parseInt( repeat );

     // Build our response string (+ concatenates)
     response = "";
     for (int i=0; i<num_repeat; i++) {
       response += name + " is way cool!\n";
     }

     JOptionPane.showMessageDialog(null, response, "Hello",
	 JOptionPane.INFORMATION_MESSAGE);

     // Quit
     System.exit( 0 );
   }

}
