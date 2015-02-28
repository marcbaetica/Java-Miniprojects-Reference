//this is a simple TCP connection server in java
//make sure to also refer to the jpg slides in the main folder for more details on TCP socket programming 


import java.io.*; //for input/output of packet data
import java.net.*; //for socket programming

public class TCPServer {

	public static void main (String[] Args) throws IOException {
		
		String clientSentence;
		String capitalizedSentence;
		
		ServerSocket listensock = new ServerSocket(6789); //create a listening socket binding to port 6789
		
		while(true) {
		
			Socket svrsock = listensock.accept(); //calling the accept method when a client connection is requested returns a connection Socket object
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(svrsock.getInputStream())); //ok so esentially these three commands in one line create an input stream reader from machine language(InputStreamReader) to human language(BufferedReader) and attach it to the socket
			clientSentence = inFromClient.readLine(); //client request is red from socket and stored as a String
			capitalizedSentence = clientSentence.toUpperCase() + '\n'; //converts input to upper case capitals
			
			DataOutputStream outToClient = new DataOutputStream(svrsock.getOutputStream()); //creates OutputStream and attaches it to the socket
			outToClient.writeBytes(capitalizedSentence); //write the capitalized input back to the Client 
			
		}
	}
}
