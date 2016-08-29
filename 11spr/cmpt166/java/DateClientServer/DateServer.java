import java.util.Date;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

public class DateServer {
	
	private int port;

	private ServerSocket serverSock;
	private Socket connection;
	private Scanner clientIn;
	private PrintWriter clientOut;
	
	public DateServer(int port) {
		this.port = port;
        if (this.port <= 0) this.port = 7654;
	}
	public DateServer() { this(0); }
	
	public boolean connect() {
		try	{
			System.out.println("Waiting for a connection on port " + port);
			serverSock = new ServerSocket(port);
			connection = serverSock.accept();
			
			clientIn = new Scanner( connection.getInputStream() );
			clientOut = new PrintWriter( connection.getOutputStream(), true );
			
			System.out.println("Connected to client!");
			return true;

		} catch (IOException e) {
				System.out.println(e.getMessage());
				return false;
		}
	}
	
	public void listen() {
		Date now = new Date();
		String clientText = clientIn.nextLine();
		String replyText = "Welcome, " + clientText + ", Today is " + now.toString() + "\n";
		clientOut.println(replyText);
		System.out.println("Sent: " + replyText);
	}
	
	public boolean close() {
		try {
			clientOut.close();
			clientIn.close();
			connection.close();
			serverSock.close();
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void main(String[] args) {
		DateServer server = new DateServer();
		server.connect();
		server.listen();
		server.close();
	}
}
