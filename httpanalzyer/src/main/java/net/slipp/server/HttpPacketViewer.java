package net.slipp.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpPacketViewer extends Thread {
	private static final String HTML_START = "<html>"
			+ "<title>HTTP Packet Viewer in java</title>" + "<body>";

	private static final String HTML_END = "</body>" + "</html>";
	
	Socket connectedClient = null;
	BufferedReader inFromClient = null;
	DataOutputStream outToClient = null;

	public HttpPacketViewer(Socket client) {
		connectedClient = client;
	}

	public void run() {
		try {
			System.out.println("The Client " + connectedClient.getInetAddress()
					+ ":" + connectedClient.getPort() + " is connected");

			inFromClient = new BufferedReader(new InputStreamReader(
					connectedClient.getInputStream()));
			outToClient = new DataOutputStream(
					connectedClient.getOutputStream());

			String currentLine = inFromClient.readLine();
			String headerLine = currentLine;
			if (headerLine == null) {
				return;
			}
			
			do {
				System.out.println("currentLine : " + currentLine);
				currentLine = inFromClient.readLine();
			} while (inFromClient.ready()); // End of do-while

			sendResponse(200,  "Success!");
			inFromClient.close();
			connectedClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendResponse(int statusCode, String responseString)
			throws Exception {
		String statusLine = null;
		String serverdetails = "Server: Java HTTPServer";
		String contentLengthLine = null;
		String contentTypeLine = "Content-Type: text/html" + "\r\n";

		if (statusCode == 200)
			statusLine = "HTTP/1.1 200 OK" + "\r\n";
		else
			statusLine = "HTTP/1.1 404 Not Found" + "\r\n";

		responseString = HTML_START + responseString
				+ HTML_END;
		contentLengthLine = "Content-Length: " + responseString.length()
				+ "\r\n";

		outToClient.writeBytes(statusLine);
		outToClient.writeBytes(serverdetails);
		outToClient.writeBytes(contentTypeLine);
		outToClient.writeBytes(contentLengthLine);
		outToClient.writeBytes("Connection: close\r\n");
		outToClient.writeBytes("\r\n");
		outToClient.writeBytes(responseString);

		outToClient.close();
	}

	public static void main(String args[]) throws Exception {
		ServerSocket server = new ServerSocket(5000, 10,
				InetAddress.getByName("localhost"));
		System.out.println("HTTP Server Waiting for client on port 5000");

		while (true) {
			Socket connected = server.accept();
			(new HttpPacketViewer(connected)).start();
		}
	}
}
