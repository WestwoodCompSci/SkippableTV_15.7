package skippable.client.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import skippable.client.SkippableClient;
import skippable.client.backend.ClientBackend;

public class ForgotPasswordPanel extends JPanel
{
	private SkippableClient client;
	private ClientBackend backend;
	
	public ForgotPasswordPanel(SkippableClient client) {
		this.client = client;
		
		this.setPreferredSize(new Dimension(600,400));
		this.setLocation(600, 400);
		
		Box fBox = Box.createVerticalBox();
		this.add(fBox);
		//testframe.add(rpanel);
		
		Box emailfBox = Box.createHorizontalBox();
		Box recoverfBox = Box.createHorizontalBox();
				
		fBox.add(Box.createVerticalStrut(100));
		fBox.add(emailfBox);
		fBox.add(Box.createVerticalStrut(100));
		fBox.add(recoverfBox);
				
		final JTextField emailFieldF = new JTextField("Email");
		final JButton recoverBF = new JButton("Recover Password");
		//
		
	//Testing
		//lpanel.setBackground(Color.RED);
	
//---------------------------------------------------------------------------------------	

	//Register Panel	
		
		//Email Box
		
		emailFieldF.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//JOptionPane.showMessageDialog(frame, arg0.getKeyCode());
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					recoverBF.doClick();
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
		
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
		
			}} );

		emailfBox.add(Box.createHorizontalStrut(0));
		emailfBox.add(emailFieldF);
			
		//Recover Box
	
		recoverBF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("A recovery email has been sent to the specified e-mail address.");
			}} );
		
		recoverfBox.add(Box.createHorizontalStrut(0));
		recoverfBox.add(recoverBF);

	}
}
