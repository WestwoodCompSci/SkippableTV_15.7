package skippable.client;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	Box vBTop;
	Box vBBottom;
	
	private ImageIcon icon;
	
	private JLabel logo;
	
	private SkippableClient(){
		
		//make dat frame
		f = new JFrame("SKiPpaBLe.TV");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(600,400));
		
		vBTop = Box.createVerticalBox();
		vBBottom = Box.createVerticalBox();
		
		setPanel(new LoginPanel(this));
		
		icon= new ImageIcon("finallogo.png");
		logo.setIcon(icon);
		vBTop.add(logo);
		
		f.add(vBTop);
		f.add(vBBottom);
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
			vBBottom.remove(currentJPanel);
		}
		vBBottom.add(panel);
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
