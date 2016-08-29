/**
 * Calculate Fibonacci numbers.
 *
 * @author Sean Ho
 * @studentid 314159
 * @course CMPT 167
 */

// any imports go here
import javax.swing.*;

/**
 * Calculate Fibonacci numbers.
 */
public class Fibonacci {
  long[] cache;			// pre-calculated Fibs
  final int DEFAULT_SIZE = 100;	// default arg to constructor

  /**
   * Initialize the cache of pre-calculated Fibonacci numbers.
   */
  private void clearCache() {
    cache[0] = cache[1] = 1;
    for (int i = 2; i < cache.length; i++) {
      cache[i] = 0;
    }
  }

  /**
   * Constructor: default cache size is DEFAULT_SIZE
   */
  Fibonacci() {
    cache = new long[DEFAULT_SIZE];
    clearCache();
  }

  /**
   * Constructor
   * @param size How big to make the cache
   */
  Fibonacci( int size ) {
    if (size < 2) size = 2;
    cache = new long[size];  
    clearCache();
  }

  /**
   * Calculate the nth Fibonacci number.
   * @param n Which Fibonacci number (must be less than cache size)
   * @return The Fibonacci number
   */
  long fib( int n ) {
    if (n > cache.length) return 0;
    if (cache[n] != 0) return cache[n];
    cache[n] = fib(n-2) + fib(n-1);
    return cache[n];
  }

  /**
   * Quick test of the Fibonacci subroutine
   */
  public static void main( String args[] ) {

    // Set the look-and-feel to match the current system
    try {
      UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
    } catch (UnsupportedLookAndFeelException e) {
    } catch (ClassNotFoundException e) {
    } catch (InstantiationException e) {
    } catch (IllegalAccessException e) {
    }

    int max = Integer.parseInt( JOptionPane.showInputDialog(
	"What's the largest Fibonacci number you'll want?" ) );
    Fibonacci f = new Fibonacci(max);

    int n = 1;
    while (n > 0) {
      n = Integer.parseInt( JOptionPane.showInputDialog(
	  "Which Fibonacci number? (<" + max + "; enter 0 to quit)" ) );
      if (n > 0 && n < max)
	JOptionPane.showMessageDialog(null, 
	    "Fibonacci(" + n + ") = " + f.fib(n), "Fibonacci",
	 JOptionPane.INFORMATION_MESSAGE);
    }
  }
}
