package skippable.client.gui;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import skippable.client.backend.ClientBackend;
import skippable.client.backend.Show;

public class HomePanel{

	private JPanel homePanel;
	private static ClientBackend backEnd;
	private ArrayList<Show> myShows = backEnd.getUserShows();
	
	public HomePanel(ClientBackend backEnd){
		
		this.backEnd = backEnd;
		
		//Creates the panel
		homePanel = new JPanel();
		homePanel.setPreferredSize(new Dimension(500, 500));
		
		//Genre DropDown
		JComboBox<String> getGenre = new JComboBox();
		getGenre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		
		//Labels
		JLabel myShowsLabel = new JLabel("My Shows");
		
		//Genre drop down
		Box genreChoice = Box.createVerticalBox();
		genreChoice.add(Box.createHorizontalStrut(10));
		genreChoice.add(getGenre);
		
		//Show display
		Box showDisplay = Box.createVerticalBox();
		showDisplay.add(myShowsLabel);
		
		//Adding in the shows
		for(int i=0; i < myShows.size(); i++){
			
			Box newVerticalBox = Box.createVerticalBox();
			JLabel title = new JLabel(myShows.get(i).getTitle());
			JLabel rating = new JLabel("" + myShows.get(i).getShowRating());
			JButton showButton = new JButton();
			/*
			 * Need to add the imageicon of the button to this
			 */
			newVerticalBox.add(title);
			newVerticalBox.add(showButton);
			newVerticalBox.add(rating);
			showButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					
				}
			});
			
			showDisplay.add(newVerticalBox);
		}
		
		//Huge Vertical Box
		Box container = Box.createVerticalBox();
		container.add(genreChoice);
		container.add(showDisplay);
		homePanel.add(container);
		
	}

}
