package ca.twu.cmpt166.seanho.lab0;

import java.util.Scanner;

/**
 * A very simple "Hello, World!" Java program.
 * Demo for CMPT166: {@link http://cmpt166.seanho.com/}
 * 
 * @author Sean Ho
 */

// any imports go here

/**
 * A very simple "Hello, World!" Java program.
 * This class has no methods and no attributes;
 * it is not intended to be instantiated, just run.
 */
public class HelloWorld {

    /**
     * The main() method begins execution of the Java program.
     * 
     * @param args arguments from when program was invoked on the command
     *            line
     */
    public static void main(final String args[]) {
        // Say hello to the user!
        System.out.print("How many apples? ");
        final Scanner kbd = new Scanner(System.in);
        final int numApples = kbd.nextInt();
        System.out.print("how many oranges? ");
        final int numOranges = kbd.nextInt();
        kbd.nextLine();
        System.out.printf("You have %d apples and %d oranges!\n",
                numApples, numOranges);
    }

}
