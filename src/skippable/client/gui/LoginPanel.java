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
import skippable.client.backend.*;
import skippable.client.gui.*;

public class LoginPanel extends JPanel
{
	private JPanel myLoginPage;
	private JPanel currentPanel;
	private SkippableClient client;
	private ClientBackend backend;
	
	public LoginPanel( SkippableClient client)
	{
		myLoginPage = new JPanel();
		this.client = client;
		
		//final JFrame testframe = new JFrame("Testing the panels.");
		//testframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//testframe.setPreferredSize(new Dimension(600,400));
		//testframe.setLocation(350, 250);
		
	//Login Panel

		this.setPreferredSize(new Dimension(600,400));
		this.setLocation(600, 400);
		
		Box lBox = Box.createVerticalBox();
		this.add(lBox);
		
		Box registerlBox = Box.createHorizontalBox();
		Box usernamelBox = Box.createHorizontalBox();
		Box passwordlBox = Box.createHorizontalBox();
		
		lBox.add(registerlBox);
		lBox.add(Box.createVerticalStrut(50));
		lBox.add(usernamelBox);
		lBox.add(Box.createVerticalStrut(50));
		lBox.add(passwordlBox);
		lBox.add(Box.createVerticalStrut(50));
		
		final JTextField usernameFieldL = new JTextField("Username");
		final JTextField passwordFieldL = new JTextField("Password");
		final JButton forgotPasswordBL = new JButton("Forgot Password");
		final JButton signInBL = new JButton("Sign In");
		final JButton registerBL = new JButton("Register");
		
		usernameFieldL.setNextFocusableComponent(passwordFieldL);	
		signInBL.setNextFocusableComponent(forgotPasswordBL);
		forgotPasswordBL.setNextFocusableComponent(registerBL);
		
		//
		
	// Register Panel

		
		//
		
	//Testing
		//lpanel.setBackground(Color.RED);
	
//------------------------------------------------------------------------------		
		
	//Login Panel	
		
		//Register Box
		
		registerBL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				client.setPanel(new RegisterPanel(client));
			}} );
		
		registerlBox.add(Box.createHorizontalStrut(500));
		registerlBox.add(registerBL);
		
		//Password Box
		
		passwordFieldL.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					signInBL.doClick();
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
		
		signInBL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				client.setPanel(new HomePanel(backend));			
			}} );
		
		passwordlBox.add(Box.createHorizontalStrut(100));
		passwordlBox.add(passwordFieldL);
		passwordlBox.add(Box.createHorizontalStrut(50));
		passwordlBox.add(signInBL);
		passwordlBox.add(Box.createHorizontalStrut(130));
		
		//Username Box
		
		usernameFieldL.addKeyListener(new KeyListener() {
				@Override
			public void keyPressed(KeyEvent arg0) {
				//JOptionPane.showMessageDialog(frame, arg0.getKeyCode());
					//System.out.println("hi");
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					signInBL.doClick();
				}
				if (arg0.getKeyCode() == KeyEvent.VK_TAB)
				{
					passwordFieldL.grabFocus();
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
		
		forgotPasswordBL.addActionListener(new ActionListener() {
				@Override
			public void actionPerformed(ActionEvent e) 
			{
				client.setPanel(new ForgotPasswordPanel(client));			
			}} );
		
		usernamelBox.add(Box.createHorizontalStrut(100));
		usernamelBox.add(usernameFieldL);
		usernamelBox.add(Box.createHorizontalStrut(20));
		usernamelBox.add(forgotPasswordBL);
		usernamelBox.add(Box.createHorizontalStrut(100));
	
//---------------------------------------------------------------------------------------			
		
		//testframe.pack();
		//testframe.setVisible(true);
		
	}
}
