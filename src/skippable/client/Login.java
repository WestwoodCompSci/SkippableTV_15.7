package skippable.client;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class Login extends JPanel
{
	private JPanel myLoginPage;
	
	public Login()
	{
		myLoginPage = new JPanel();
		
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600,400));
		panel.setLocation(320, 250);
		
		Box lBox = Box.createVerticalBox();
		panel.add(lBox);
		
		Box registerBox = Box.createHorizontalBox();
		Box usernameBox = Box.createHorizontalBox();
		Box passwordBox = Box.createHorizontalBox();
		
		lBox.add(registerBox);
		lBox.add(Box.createVerticalStrut(50));
		lBox.add(usernameBox);
		lBox.add(Box.createVerticalStrut(50));
		lBox.add(passwordBox);
		lBox.add(Box.createVerticalStrut(50));
		
		final JTextField usernameField = new JTextField();
		final JTextField passwordField = new JTextField();
		final JButton forgotPasswordB = new JButton("Forgot Password");
		final JButton signInB = new JButton("Sign In");
		final JButton registerB = new JButton("Register");
		
		//Password Field
		
		passwordField.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				//JOptionPane.showMessageDialog(frame, arg0.getKeyCode());
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					signInB.doClick();
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
		
		//Sign In Button
		signInB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
			}} );
		
	}
	
	
	
}
