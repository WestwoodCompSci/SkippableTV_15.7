package skippable.client;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import skippable.client.backend.ClientBackend;
import skippable.client.gui.LoginPanel;

public class SkippableClient 
{
	public static final String ip = "127.0.0.1";
	public static final int port = 32700;
	
	private JFrame f;
	private JPanel currentJPanel;
	
	private ClientBackend backend;
	private static SkippableClient theClient;
	
	
	private SkippableClient(){
		
		//make dat frame
		f = new JFrame("SKiPpaBLe.TV");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(600,400));
		setPanel(new LoginPanel(this));
		
		backend = new ClientBackend(ip, port); // TODO change host and port to something else.
		
		//Dont Forget
		f.pack();
		f.setVisible(true);
	
	}
	
	public ClientBackend getBackend(){
		return backend;
	}

	
	public static SkippableClient get(){
		if(theClient == null){
			theClient = new SkippableClient();
		}
		return theClient;
	}
	
	public void setPanel(JPanel panel){
		if(currentJPanel != null)
		{
			f.remove(currentJPanel);
		}
		f.add(panel);
		currentJPanel = panel;
		f.pack();
	}
	
	public Dimension getSize(){
		
		Dimension d;
		d = f.getSize();
		return d;
		
	}
	
public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new SkippableClient(); }
		});
	}

}
