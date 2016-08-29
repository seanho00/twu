/** A very simple "Hello, World!" Java program.
 * Demo for CMPT166: {@link http://cmpt166.seanho.com/}
 *
 * @author Sean Ho
 */

// any imports go here

package ca.twu.cmpt166.seanho;
import java.util.Scanner;

/** A very simple "Hello, World!" Java program.
 * This class has no methods and no attributes;
 * it is not intended to be instantiated, just run.
 */
public class HelloWorld {

	/** The main() method begins execution of the Java program.
	 * @param args arguments from when program was invoked on the command line
	 * @return nothing returned
	 */
	public static void main( String args[] )
	{
		Scanner kbd = new Scanner(System.in);
		
		System.out.print( "What is your name, friend? " );
		String name = kbd.nextLine();

		System.out.print( "How many apples and oranges? " );
		int numApples = kbd.nextInt();
		int numOranges = kbd.nextInt();
		kbd.nextLine();
		System.out.printf( "%s, you have %d apples and %d oranges!\n",
				name, numApples, numOranges );
	}

}
