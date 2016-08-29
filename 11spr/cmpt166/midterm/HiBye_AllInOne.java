/** HiBye_AllInOne.java
 * Demo of ActionListener on a JButton, for CMPT166 exam.
 * This version has the main JFrame subclass do double-duty as the event handler.
 */
import javax.swing.*;
import java.awt.event.*;

public class HiBye_AllInOne extends JFrame implements ActionListener {
  	JButton quitButton;

	public HiBye_AllInOne() {
		super( "HiBye: Click to quit" );

		quitButton = new JButton( "Quit" );
		quitButton.addActionListener( this );
		add( quitButton );

		setSize( 100, 100 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}

	public void actionPerformed( ActionEvent evt ) {
		if (evt.getSource() == quitButton) {
			System.exit(0);
		}
	}

	public static void main( String[] args ) {
		new HiBye_AllInOne();
	}
}
