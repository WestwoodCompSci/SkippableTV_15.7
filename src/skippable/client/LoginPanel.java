package skippable.client;

import java.awt.Color;
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



public class LoginPanel extends JPanel
{
	private JPanel myLoginPage;
	
	public LoginPanel()
	{
		myLoginPage = new JPanel();
		
		final JFrame testframe = new JFrame("Testing the login panel");
		testframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		testframe.setPreferredSize(new Dimension(600,400));
		testframe.setLocation(350, 250);
		
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600,400));
		panel.setLocation(600, 400);
		
		Box lBox = Box.createVerticalBox();
		panel.add(lBox);
		testframe.add(panel);
		
		Box registerBox = Box.createHorizontalBox();
		Box usernameBox = Box.createHorizontalBox();
		Box passwordBox = Box.createHorizontalBox();
		
		lBox.add(registerBox);
		lBox.add(Box.createVerticalStrut(50));
		lBox.add(usernameBox);
		lBox.add(Box.createVerticalStrut(50));
		lBox.add(passwordBox);
		lBox.add(Box.createVerticalStrut(50));
		
		//Testing
		//panel.setBackground(Color.RED);
		
		//Register Box
		final JButton registerB = new JButton("Register");
		
		registerB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
								
			}} );
		
		registerBox.add(Box.createHorizontalStrut(500));
		registerBox.add(registerB);
		
		//Password Box
		final JTextField passwordField = new JTextField();
		final JButton signInB = new JButton("Sign In");
		
		passwordField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
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
		
		signInB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
								
			}} );
		
		passwordBox.add(Box.createHorizontalStrut(100));
		passwordBox.add(passwordField);
		passwordBox.add(Box.createHorizontalStrut(50));
		passwordBox.add(signInB);
		passwordBox.add(Box.createHorizontalStrut(130));
		
		//Username Box
		final JTextField usernameField = new JTextField();
		final JButton forgotPasswordB = new JButton("Forgot Password");
		
		usernameField.addKeyListener(new KeyListener() {
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
		
		forgotPasswordB.addActionListener(new ActionListener() {
				@Override
			public void actionPerformed(ActionEvent e) 
			{
								
			}} );
		
		usernameBox.add(Box.createHorizontalStrut(100));
		usernameBox.add(usernameField);
		usernameBox.add(Box.createHorizontalStrut(20));
		usernameBox.add(forgotPasswordB);
		usernameBox.add(Box.createHorizontalStrut(100));
	
		testframe.pack();
		testframe.setVisible(true);
		
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { new LoginPanel(); }
		});
	}
	
}
