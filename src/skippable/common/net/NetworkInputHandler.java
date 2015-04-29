package skippable.common.net;

import java.io.PrintWriter;
import java.util.Scanner;

public abstract class NetworkInputHandler {

	public static final String SEP = ""+((char) 30);
	public static final String LIST_SEP = ""+((char) 31);
	private Scanner in;
	private PrintWriter out;
	
	public abstract void handleInput(String input);
	
	public static String[] parseInput(String input) {
		return input.split(SEP);
	}
	
	public static String[] parseList(String list) {
		return list.split(LIST_SEP);
	}
	
	public void setSocketThread(SocketThread st) {
		this.in = new Scanner(st.getInputStream());
		this.out = new PrintWriter(st.getOutputStream());
	}
	
	public Scanner getScanner() {
		return in;
	}
	
	public PrintWriter getPrintWriter() {
		return out;
	}
	
	public static String formMessage(String key, String[] values) {
		String message = key;
		for (String value : values) {
			message += SEP + value;
		}
		
		return message;
	}
	
	public static String formList(String[] list) {
		String message = "";
		for (String item: list) {
			message += LIST_SEP + item;
		}
		return message;
	}
	
}
