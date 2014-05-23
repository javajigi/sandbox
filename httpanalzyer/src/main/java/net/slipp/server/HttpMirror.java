package net.slipp.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This program is a very simple Web server. When it receives a HTTP request it
 * sends the request back as the reply. This can be of interest when you want to
 * see just what a Web client is requesting, or what data is being sent when a
 * form is submitted, for example.
 */
public class HttpMirror {
	public static void main(String args[]) {
		try {
			// Get the port to listen on
			int port = 8000;
			// Create a ServerSocket to listen on that port.
			ServerSocket ss = new ServerSocket(port);
			// Now enter an infinite loop, waiting for & handling connections.
			for (;;) {
				// Wait for a client to connect. The method will block;
				// when it returns the socket will be connected to the client
				Socket client = ss.accept();

				// Get input and output streams to talk to the client
				BufferedReader in = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream());

				// Start sending our reply, using the HTTP 1.1 protocol
				out.print("HTTP/1.1 200 \r\n"); // Version & status code
				out.print("Content-Type: text/plain\r\n"); // The type of data
				out.print("Connection: close\r\n"); // Will close stream
				out.print("\r\n"); // End of headers

				// Now, read the HTTP request from the client, and send it
				// right back to the client as part of the body of our
				// response. The client doesn't disconnect, so we never get
				// an EOF. It does sends an empty line at the end of the
				// headers, though. So when we see the empty line, we stop
				// reading. This means we don't mirror the contents of POST
				// requests, for example. Note that the readLine() method
				// works with Unix, Windows, and Mac line terminators.
				String line;
				while ((line = in.readLine()) != null) {
					if (line.length() == 0)
						break;
					out.print(line + "\r\n");
					System.out.print(line + "\r\n");
				}

				out.close(); // Flush and close the output stream
				in.close(); // Close the input stream
				client.close(); // Close the socket itself
			} 
		}
		// If anything goes wrong, print an error message
		catch (Exception e) {
			System.err.println(e);
			System.err.println("Usage: java HttpMirror <port>");
		}
	}
}
