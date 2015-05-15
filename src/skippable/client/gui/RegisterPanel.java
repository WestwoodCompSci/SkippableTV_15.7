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

public class RegisterPanel extends JPanel {
	
	private SkippableClient client;
	private ClientBackend backend;
	
	public RegisterPanel(SkippableClient client) {
		this.client = client;
		
		this.setPreferredSize(new Dimension(600,400));
		this.setLocation(600, 400);
		
		Box rBox = Box.createVerticalBox();
		this.add(rBox);
		//testframe.add(rpanel);
		
		Box usernamerBox = Box.createHorizontalBox();
		Box passwordrBox = Box.createHorizontalBox();
		Box emailrBox = Box.createHorizontalBox();
		Box registerrBox = Box.createHorizontalBox();
		
		rBox.add(Box.createVerticalStrut(50));
		rBox.add(usernamerBox);
		rBox.add(Box.createVerticalStrut(50));
		rBox.add(passwordrBox);
		rBox.add(Box.createVerticalStrut(50));
		rBox.add(emailrBox);
		rBox.add(Box.createVerticalStrut(50));
		rBox.add(registerrBox);
		
		final JTextField usernameFieldR = new JTextField("Username");
		final JTextField passwordFieldR = new JTextField("Password");
		final JTextField emailFieldR = new JTextField("Email");
		final JButton registerBR = new JButton("Register");
		//
		
	//Testing
		//lpanel.setBackground(Color.RED);
	
//---------------------------------------------------------------------------------------	

	//Register Panel	
		
		//Username Box
		
		usernameFieldR.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//JOptionPane.showMessageDialog(frame, arg0.getKeyCode());
					if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
					{
						registerBR.doClick();
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
	
		usernamerBox.add(Box.createHorizontalStrut(0));
		usernamerBox.add(usernameFieldR);
		usernamerBox.add(Box.createHorizontalStrut(0));
		
		//Password Box
	
		passwordFieldR.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//JOptionPane.showMessageDialog(frame, arg0.getKeyCode());
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					registerBR.doClick();
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

		passwordrBox.add(Box.createHorizontalStrut(0));
		passwordrBox.add(passwordFieldR);
		
		//Email Box
		
		emailFieldR.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//JOptionPane.showMessageDialog(frame, arg0.getKeyCode());
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					registerBR.doClick();
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

		emailrBox.add(Box.createHorizontalStrut(0));
		emailrBox.add(emailFieldR);
			
		//Register Box
	
		registerBR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				client.setPanel(new HomePanel(backend));
			}} );
		
		registerrBox.add(Box.createHorizontalStrut(0));
		registerrBox.add(registerBR);

	}

}
