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
	private JPanel CurrentJPanel;
	
	private ClientBackend backend;
	
	SkippableClient(ClientBackend backend){
		
		//make dat frame
		this.backend = backend;
		f = new JFrame("SKiPpaBLe.TV");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(600,400));
		LoginPanel l = new LoginPanel();
		f.add(l);
		CurrentJPanel = l;
		
		backend = new ClientBackend("127.0.0.1", 32700); // TODO change host and port to something else.
		
		//Dont Forget
		f.pack();
		f.setVisible(true);
	
	}
	
	public void setPanel(JPanel Panel){
		
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
