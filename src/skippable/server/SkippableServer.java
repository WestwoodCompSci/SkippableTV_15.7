package skippable.server;

import java.io.IOException;
import java.net.ServerSocket;

import skippable.server.net.ConnectionThread;

public class SkippableServer {

	private ServerSocket serverSocket;
	private ConnectionThread connThread;
	
	public SkippableServer(int port) {
		
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setSoTimeout(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connThread = new ConnectionThread(getServerSocket());
		connThread.start();
	}
	
	public SkippableServer() {
		this(32700);
	}
	
	public ServerSocket getServerSocket() {
		
		return serverSocket;
		
	}
	
	public static void main(String[] args) {
		
		new SkippableServer(32700);
		
	}
}
