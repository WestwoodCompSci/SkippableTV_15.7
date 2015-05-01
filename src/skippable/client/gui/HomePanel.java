package skippable.client.gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import skippable.client.backend.ClientBackend;
import skippable.client.backend.Show;

public class HomePanel extends JFrame{

	private JPanel homePanel;
	private ClientBackend backEnd;
	private ArrayList<Show> myShows = backEnd.getUserShows();
	
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
		
		//Adding in the shows
		for(int i=0; i < myShows.size(); i++){
			
		}
		
	}
}
