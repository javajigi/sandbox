package net.slipp.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class RequestHandler extends Thread {
	private static final String DEFAULT_WEB_ROOT = "webapps";
	// 파일 요청이 없을 경우의 기본 파일
	private static final String DEFAULT_FILE_PATH = "index.html";

	// 클라이언트와의 접속 소켓
	private Socket connection;

	public RequestHandler(Socket connectionSocket) {
		this.connection = connectionSocket;
	}

	@Override
	public void run() {
		System.out.println("Connected Client!");
		
		BufferedReader inFromClient = null;
		DataOutputStream outToClient = null;

		try {
			// 클라이언트와 통신을 위한 입/출력 2개의 스트림을 생성한다.
			inFromClient = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			outToClient = new DataOutputStream(connection.getOutputStream());

			// 클라이언트로의 메시지중 첫번째 줄을 읽어들인다.
			String requestMessageLine = inFromClient.readLine();
			if (requestMessageLine == null) {
				return;
			}

			// 파싱을 위한 토큰을 생성한다.
			StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);
			
			while (tokenizedLine.hasMoreTokens()) {
				System.out.println(tokenizedLine.nextToken());
			}

//			// 첫번째 토큰이 GET으로 시작하는가? ex) GET /green.jpg
//			if (tokenizedLine.nextToken().equals("GET")) {
//				// 다음의 토큰은 파일명이다.
//				String fileName = tokenizedLine.nextToken();
//
//				// 기본적으로 루트(/)로부터 주소가 시작하므로 제거한다.
//				if (fileName.startsWith("/") == true) {
//					if (fileName.length() > 1) {
//						fileName = fileName.substring(1);
//					}
//					// 파일명을 따로 입력하지 않았을 경우 기본 파일을 출력한다.
//					else {
//						fileName = DEFAULT_WEB_ROOT + File.separator
//								+ DEFAULT_FILE_PATH;
//					}
//				}
//
//				File file = new File(fileName);
//				// 요청한 파일이 존재하는가?
//				if (file.exists()) {
//					// 파일의 바이트수를 찾아온다.
//					int numOfBytes = (int) file.length();
//					FileInputStream inFile = new FileInputStream(fileName);
//					byte[] fileInBytes = new byte[numOfBytes];
//					inFile.read(fileInBytes);
//
//					setResponseHeader200(outToClient, numOfBytes);
//
//					// 요청 파일을 출력한다.
//					outToClient.write(fileInBytes, 0, numOfBytes);
//					outToClient.writeBytes("\r\n");
//					outToClient.flush();
//					inFile.close();
//				} else {
//					setContentTypeTo404(outToClient, fileName);
//				}
//			} else {
//				setContentTypeTo400(outToClient);
//			}
			
			byte[] message = "Hello World !".getBytes();
			setResponseHeader200(outToClient, message.length);
			outToClient.write(message, 0, message.length);
			outToClient.writeBytes("\r\n");
			outToClient.flush();

			connection.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void setContentTypeTo400(DataOutputStream outToClient)
			throws IOException {
		outToClient.writeBytes("HTTP/1.0 400 Bad Request Message \r\n");
		outToClient.writeBytes("Connection: close\r\n");
		outToClient.writeBytes("\r\n");
	}

	private void setContentTypeTo404(DataOutputStream outToClient,
			String fileName) throws IOException {
		outToClient.writeBytes("HTTP/1.0 404 Not Found \r\n");
		outToClient.writeBytes("Connection: close\r\n");
		outToClient.writeBytes("\r\n");
	}

	private void setResponseHeader200(DataOutputStream outToClient,
			int numOfBytes) throws IOException {
		outToClient.writeBytes("HTTP/1.0 200 Document Follows \r\n");
		outToClient.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
		outToClient.writeBytes("Content-Length: " + numOfBytes + "\r\n");
		outToClient.writeBytes("\r\n");
	}
}
