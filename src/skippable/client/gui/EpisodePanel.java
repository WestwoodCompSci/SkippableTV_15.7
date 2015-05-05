package skippable.client.gui;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import skippable.client.backend.Episode;

public class EpisodePanel extends JPanel
{
	Episode myEpisode;

	
	public EpisodePanel(Episode ep)
	{
		//mySkip = myEpisode.getEpisodeSkippability();
															//int --> String --> Image ?
		myEpisode = ep;
		
		Box mainBox = Box.createVerticalBox();
		
		//TV show info		
		JTextField titleField = new JTextField(myEpisode.getTitle());
		Box titleHBox = Box.createHorizontalBox();							//contains bars, show name, show rating, season #, episode #
		Image skipBars = null;
		try {
			skipBars = ImageIO.read(new File("image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}							//skip bars, unique to episode
		Box showStarsV = Box.createVerticalBox();							//show name, show rating, season #, episode #
		Box showStarsH = Box.createHorizontalBox();							//show name, show rating (image?)
		JTextField showName = new JTextField(myEpisode.getShow().getTitle());
		showStarsH.add(showName);
		showStarsH.add(new JTextField(myEpisode.getShow().getShowRating()));
		showStarsV.add(showStarsH);
		
		Box pic = Box.createHorizontalBox();
		pic.paint(skipBars.getGraphics());
		titleHBox.add(pic);						 							//figure out how to add image to component
		
		//episode info
		Box summTitle = Box.createHorizontalBox();
		JTextField summTitleWords = new JTextField("Episode Summary");
		JButton editSumm = new JButton("Edit");
		JButton pubSumm = new JButton("Publish");							//hidden until edit pressed
		Box summaryBox = Box.createHorizontalBox();
		
		Box commentsH = Box.createHorizontalBox();							//strut
		Box commentsV = Box.createVerticalBox();
		
		summTitle.add(summTitleWords);
		summTitle.add(editSumm);
		pubSumm.setVisible(false);
		summTitle.add(pubSumm);
		
		
		//strut
		JButton addCom = new JButton("Add comment");
		
		
		
	}
}
