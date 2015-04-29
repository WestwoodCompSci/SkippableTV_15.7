package skippable.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import skippable.client.net.ClientInputHandler;
import skippable.common.net.NetworkInputHandler;
import skippable.common.net.SocketThread;

public class ClientBackend {
	
	private String username;
	private String email;
	private String password;
	private List<Show> userShows;
	
	SocketThread thread;
	
	public ClientBackend(String host, int port) {
		
		try {
			thread = new SocketThread(new Socket(host, port), new ClientInputHandler());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter pw = new PrintWriter(thread.getOutputStream());
		pw.println(NetworkInputHandler.formMessage("TEST", new String[]{"hello", "hi"}));
		pw.flush();
		
	}
	
}
