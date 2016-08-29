import javax.swing.*;

public class TimeTest {
  public static void main( String args[] ) {
    Time1 time = new Time1();

    String output = "The initial universal time is: " +
      time.toUniversalString() +
      "\nThe initial standard time is: " + time.toString() +
      "\nImplicit toString call: " + time;

    time.setTime( 13, 27, 6 );
    output += "\n\nAfter setTime: " + time;

    time.setTime( 99, 99, 99 );
    output += "\n\nAfter invalid setTime: " + time;

    JOptionPane.showMessageDialog( null, output, "TimeTest",
	JOptionPane.INFORMATION_MESSAGE );
    System.exit( 0 );
  }
}
