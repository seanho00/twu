/** HiBye_Inner.java
 * Demo of ActionListener on a JButton, for CMPT166 exam.
 * This version uses an inner class for the event listener.
 */
import javax.swing.*;
import java.awt.event.*;

public class HiBye_Inner extends JFrame {
  	JButton quitButton;

	public HiBye_Inner() {
		super( "HiBye: Click to quit" );

		quitButton = new JButton( "Quit" );
		quitButton.addActionListener( new QuitListener() );
		add( quitButton );

		setSize( 100, 100 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}

	private class QuitListener implements ActionListener {
		public void actionPerformed( ActionEvent evt ) {
			System.exit(0);
		}
	}

	public static void main( String[] args ) {
		new HiBye_Inner();
	}
}
