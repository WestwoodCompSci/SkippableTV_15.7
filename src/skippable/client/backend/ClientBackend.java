package skippable.client.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import skippable.client.net.ClientInputHandler;
import skippable.client.net.PHPInterface;
import skippable.common.net.NetworkInputHandler;
import skippable.common.net.SocketThread;

public class ClientBackend {
	
	private String username;
	private String email;
	private String password;
	private ArrayList<Show> userShows;
	
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
	
	public boolean login(String username, String password) {
		return false;
	}
	
	public void register(String username, String email, String password) {
		PHPInterface reg = new PHPInterface(PHPInterface.DEFAULT_REGISTER);
		reg.add("username", username);
		reg.add("email", email);
		reg.add("emailre", email);
		reg.add("password", password);
		reg.add("passwordre", password);
		try {
			reg.post();
		} catch (Exception e) {
			// Darn it!
			e.printStackTrace();
		}
	}
	
	
	public void addUserShow(Show myShow){
		
	}
	
	public void removeUserShow(Show myShow){
		
		
	}
	
	public  String getUsername() {
		return username;
	}
	
	public ArrayList<Show> getUserShows() {
		return userShows;
	}
	
	
	
	
}
