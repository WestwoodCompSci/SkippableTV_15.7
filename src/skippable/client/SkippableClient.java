package skippable.client;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

public class SkippableClient 
{
	private JFrame f;
	private JPanel CurrentJPanel;
	
	SkippableClient()
	{
		//make das frame
	f = new JFrame("Skippable.TV");
	f.setPreferredSize(new Dimension(600,400));
	Login l = new Login();
	f.add(l);
	CurrentJPanel = l;
	//Dont Forget
	f.pack();
	f.setVisible(true);
	}
	public Dimension getSize()
	{
		Dimension d;
		d = f.getSize();
		return d;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { new SkippableClient(); }
		});
	}

}
