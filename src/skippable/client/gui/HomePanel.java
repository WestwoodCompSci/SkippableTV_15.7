package skippable.client.gui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import skippable.client.ClientBackend;

public class HomePanel extends JFrame{

	private JPanel homePanel;
	private ClientBackend backEnd;
	
	public HomePanel(ClientBackend backEnd){
		
		this.backEnd = backEnd;
		
		//Creates the panel
		homePanel = new JPanel();
		homePanel.setPreferredSize(new Dimension(super.getSize()));
		
		//Buttons
		JComboBox getGenre = new JComboBox();
		
		//Labels
		JLabel myShows = new JLabel("My Shows");
		
		//Get userShows
		
		//Genre drop down
		Box genreChoice = Box.createVerticalBox();
		genreChoice.add(Box.createHorizontalStrut(10));
		genreChoice.add(getGenre);
		
		//Show display
		Box showDisplay = Box.createVerticalBox();
		
	}
}
