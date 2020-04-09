package DebuggingCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket aSocket;
	private BufferedReader br;
	private PrintWriter pw;
	private BufferedReader stdIn;
	
	public Client(int port) {
		try {
			aSocket = new Socket("localhost", port);
			
			br = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			pw = new PrintWriter(aSocket.getOutputStream(), true);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void communicate() {
		String fromServer = "";
		String toServer = null;
		
		while(!fromServer.contentEquals("QUIT")) {
			try {
				System.out.println("Please enter a string to communicate with server");
				toServer = stdIn.readLine();
				System.out.println("Sending: " + toServer);
				pw.println(toServer);
				
				fromServer = br.readLine();
				System.out.println("Response from server is: " + fromServer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String [] args) {
		Client c = new Client(9898);
		c.communicate();
	}
	
	
	
}