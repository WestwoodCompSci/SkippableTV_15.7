package skippable.client.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import skippable.client.net.ClientInputHandler;
import skippable.client.net.PHPInterface;
import skippable.common.net.NetworkInputHandler;
import skippable.common.net.SocketThread;

public class ClientBackend {
	
	private String username;
	private String email;
	private String password;
	private ArrayList<Show> userShows;
	
	private Map<String, Show> showsByGenre;
	
	SocketThread thread;
	
	private boolean usePHP = false;
	
	public ClientBackend(String host, int port) {
		
		try {
			thread = new SocketThread(new Socket(host, port), new ClientInputHandler());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConnectException e) {
			System.err.println("Server not found at "+host+":"+port+"! Falling back to PHP.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (thread == null) {
			usePHP = true;
		} else {
			PrintWriter pw = new PrintWriter(thread.getOutputStream());
			pw.println(NetworkInputHandler.formMessage("TEST", new String[]{"hello", "hi"}));
			pw.flush();
		}
		
		// TODO replace the following with actually not placeholder code
		showsByGenre = new HashMap<String, Show>();
		showsByGenre.put("Sci-Fi", new Show("Star Trek: Deep Space Nine", "Sci-Fi", "Space station"));
		showsByGenre.put("Drama", new Show("Mean Girls", "Drama", "A girl attempts to torture 'alpha girls,' but she becomes one herself."));
		showsByGenre.put("Action", new Show("Team America: World Police", "Action", "Uh uh hard to say"));		
		
	}
	
	public boolean login(String username, String password) {
		if (usePHP) {
			PHPInterface log = new PHPInterface(PHPInterface.DEFAULT_LOGIN);
			log.add("username", username);
			log.add("password", password);
			try {
				System.out.println(log.post());
			} catch (IOException e) {
				// Darn it!
				e.printStackTrace();
			}
		} else {
			
		}
		return false;
	}
	
	public void register(String firstName, String lastName, String email, String password) {
		if (usePHP) {
			PHPInterface reg = new PHPInterface(PHPInterface.DEFAULT_REGISTER);
			reg.add("first", firstName);
			reg.add("last", lastName);
			reg.add("email", email);
			reg.add("emailre", email);
			reg.add("password", password);
			reg.add("passwordre", password);
			try {
				System.out.println(reg.post());
			} catch (Exception e) {
				// Darn it!
				e.printStackTrace();
			}
		} else {
			
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
	
	public Map<String, Show> getShowsByGenre() {
		return showsByGenre;
	}
	
	
}
