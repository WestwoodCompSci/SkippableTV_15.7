package skippable.client.gui;
import java.awt.Image;
import java.util.List;

import javax.swing.*;

public class EpisodePanel extends JPanel
{
	Episode myEpisode;
	//List<String> myComments;
	
	public EpisodePanel()
	{
		Box mainBox = Box.createVerticalBox();
		
		//TV show info		
		JTextField titleField = new JTextField(myEpisode.getTitle());
		Box titleHBox = Box.createHorizontalBox();							//contains bars, show name, show rating, season #, episode #
		Image skipBars = new Image("");										//skip bars, unique to episode
		Box showStarsV = Box.createVerticalBox();							//show name, show rating, season #, episode #
		Box showStarsH = Box.createHorizontalBox();							//show name, show rating (image?)
		JTextField showName = new JTextField(myEpisode.getShow().getTitle());
		showStarsH.add(showName);
		
		showStarsV.add(showStarsH);
		
		//episode info
		Box summTitle = Box.createHorizontalBox();
		JButton editSumm = new JButton("Edit");
		JButton pubSumm = new JButton("Publish");							//hidden until edit pressed
		Box summaryBox = Box.createHorizontalBox();
		
		Box commentsH = Box.createHorizontalBox();							//strut
		Box commentsV = Box.createVerticalBox();
		
		//strut
		JButton addCom = new JButton("Add comment");
		
		
		
	}
}
