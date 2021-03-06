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

import skippable.client.SkippableClient;
import skippable.client.backend.ClientBackend;
import skippable.client.backend.Show;

public class HomePanel extends JPanel{

	private JPanel homePanel;
	private static ClientBackend backEnd;
	private ArrayList<Show> myShows;
	
	public HomePanel(){
		
		this.backEnd = SkippableClient.get().getBackend();
		myShows= (backEnd.getUserShows());
		
		//Creates the panel
		homePanel = new JPanel();
		
		//Genre DropDown
		JComboBox<String> getGenre = new JComboBox();
		for(String s : backEnd.getShowsByGenre().keySet()){
			getGenre.addItem(s);
		}
		JButton genre = new JButton("Browse");
		genre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				String g = (String) getGenre.getSelectedItem();
				for(int i = 0; i<backEnd.getShowsByGenre().size(); i++){
					
					Box newVerticalBox = Box.createVerticalBox();
					JLabel rating = new JLabel("" + myShows.get(i).getShowRating());
					JButton showButton = new JButton(myShows.get(i).getTitle());
					JLabel img = new JLabel(myShows.get(i).getImage());
					newVerticalBox.add(showButton);
					newVerticalBox.add(img);
					newVerticalBox.add(rating);
					showButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0){
							
							//SkippableClient.get().setPanel(new ShowPanel());
						}
					});
				}
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
		
		//Huge Vertical Box
				Box container = Box.createVerticalBox();
				container.add(genreChoice);
				container.add(showDisplay);
				homePanel.add(container);
		
		//Adding in the shows
		for(int i=0; i < myShows.size(); i++){
			
			Box newVerticalBox = Box.createVerticalBox();
			JLabel rating = new JLabel("" + myShows.get(i).getShowRating());
			JButton showButton = new JButton(myShows.get(i).getTitle());
			JLabel img = new JLabel(myShows.get(i).getImage());
			newVerticalBox.add(showButton);
			newVerticalBox.add(img);
			newVerticalBox.add(rating);
			showButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					
					//SkippableClient.get().setPanel(new ShowPanel());
				}
			});
			
			showDisplay.add(newVerticalBox);
		}
		
	}

}
