package skippable.common.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketThread extends Thread implements Closeable {

	private Socket socket;
	private boolean persist;
	private Scanner s;
	private static int threadNo;
	private NetworkInputHandler nih;
	
	public SocketThread(Socket s, NetworkInputHandler nih) {
		setName("SocketThread-"+(++threadNo));
		socket = s;
		persist = true;
		this.nih = nih;
	}
	
	public InputStream getInputStream() {
		InputStream inputStream = null;
		try {
			inputStream = socket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputStream;
	}
	
	public OutputStream getOutputStream() {
		OutputStream outputStream = null;
		try {
			outputStream = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputStream;
	}
	
	@Override
	public void run() {
			
		s = new Scanner(getInputStream());
		
		while(persist) {
			
			if (s.hasNextLine()) {
				nih.handleInput(s.nextLine());
			}
			
		}
		
	}
	
	public void handleInput(String input) {
		// DO SOMETHING HERE
		
		if (input.equals("OK")) {
			PrintWriter pw = new PrintWriter(getOutputStream());
			pw.println("Got message");
			pw.flush();
		}
	}
	
	@Override
	public void close() {
		persist = false;
		s.close();
	}
	
}
