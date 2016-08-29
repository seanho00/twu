import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class DateClient {
	
	private String name;

	private String hostname;
	private int port;
	
	private Socket connection;
	private Scanner serverIn;
	private PrintWriter serverOut;
	
	public DateClient( String hostname, int port ) {
		if (hostname == null) hostname = "localhost";
		if (port <= 0) port = 7654;
		this.hostname = hostname;
		this.port = port;
		
		this.name = "Dusty Rhodes";
	}
	public DateClient() { this(null, 0); }

	/** Connect to the server and setup text-based I/O channels.
	 * 
	 * @return true if connection was successful
	 */
	public boolean connect() {
		try	{
			System.out.print("Connecting to server "
					+ hostname + " on port " + port + "... ");
			connection = new Socket(hostname, port);
			System.out.println("Connected!");

			serverIn = new Scanner( connection.getInputStream() );
			serverOut = new PrintWriter( connection.getOutputStream(), true );
			
			return true;
		} catch (IOException e)	{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/** Send my name to the server, and get a reply from the server.
	 * 
	 */
	public void sendName() {
		System.out.println("Sending my name: " + name);
		serverOut.println(name);

		System.out.println("Waiting for reply... ");
		String serverData = serverIn.nextLine();
		System.out.println("Received: " + serverData);
	}
	
	/** Clean up!
	 * 
	 */
	public void close() {
		try {
			serverIn.close();
			serverOut.close();
			connection.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		DateClient client = new DateClient();
		client.connect();
		client.sendName();
		client.close();
	}
}
