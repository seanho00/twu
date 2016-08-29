/**
 * Demonstrate inheritance using Dot and Point.
 *
 * @author Sean Ho
 * @studentid 314159
 * @course CMPT 167
 */

// any imports go here
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * Point: superclass holds (x,y) coords
 */
class Point {
  protected int x, y;	// coords

  /**
   * Constructors
   */
  public Point() {
    setPoint( 0, 0 );
  }
  public Point(int newx, int newy) {
    setPoint( newx, newy );
  }

  /**
   * Set the (x,y) coordinates
   */
  public void setPoint( int newx, int newy ) {
    x = newx;
    y = newy;
  }

  /**
   * String representation
   */
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}

/**
 * Subclass adds a size (radius) to the Point
 */
class Dot extends Point {
  protected double radius;

  /**
   * Constructors
   */
  public Dot() {
    // implicit call to Point() constructor here
    setRadius( 0 );
  }
  public Dot( double newr, int newx, int newy ) {
    super( newx, newy );	// explicit call to Point() constructor
    setRadius( newr );
  }

  /**
   * Set the size (radius) of the dot.
   */
  public void setRadius( double newr ) {
    radius = ( newr >= 0. ? newr : 0. );
  }

  /**
   * Calculate the area of the circle.
   */
  public double area() {
    return Math.PI * radius * radius;
  }

  /**
   * String representation.  Overrides superclass method.
   */
  public String toString() {
    return "Center = (" + x + ", " + y
      + "); Radius = " + radius;
  }
}

/**
 * Testbed for Point and Dot classes.
 */
public class PointDot {
  public static void main( String args[] ) {
    Point p1, p2;
    Dot d1, d2;
    String output;

    p1 = new Point( 30, 50 );
    d1 = new Dot( 2.7, 120, 89 );

    output = "Point p1: " + p1 + "\n" + "Dot d1: " + d1 + "\n\n";

    p2 = d1;		// Assign a subclass object to a superclass ref

    output += "d1 via Point p2:\n\t" + p2 + "\n\n";

    d2 = ( Dot ) p2;	// Downcast a Point to a Dot

    output += "d1 via Point p2 downcast to Dot d2:\n\t" + d2 + "\n\n";

    DecimalFormat prec = new DecimalFormat( "0.00" );
    output += "Area of d2: " + prec.format( p2.area() ) + "\n\n";

    JOptionPane.showMessageDialog( null, output, "PointDot",
	JOptionPane.INFORMATION_MESSAGE );
    System.exit( 0 );
  }
}
