package skippable.client;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import skippable.client.backend.ClientBackend;
import skippable.client.gui.LoginPanel;

public class SkippableClient 
{
	private JFrame f;
	private JPanel currentJPanel;
	
	private ClientBackend backend;
	
	SkippableClient(ClientBackend backend){
		
		//make dat frame
		this.backend = backend;
		f = new JFrame("SKiPpaBLe.TV");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(600,400));
		setPanel(new LoginPanel(this));
		
		//backend = new ClientBackend("127.0.0.1", 32700); // TODO change host and port to something else.
		
		//Dont Forget
		f.pack();
		f.setVisible(true);
	
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
			public void run() { new SkippableClient(new ClientBackend("127.0.0.1", 32700)); }
		});
	}

}
