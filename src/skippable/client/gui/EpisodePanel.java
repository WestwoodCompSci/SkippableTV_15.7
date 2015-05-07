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
	int mySkip;
	
	public EpisodePanel(Episode ep)
	{
		mySkip = myEpisode.getEpisodeSkippability();
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
		
		
		Box skipBarsBox = Box.createVerticalBox();
		
		JButton bar1 = new JButton();
		if (mySkip>=1) {
			  try {
			    Image img = ImageIO.read(getClass().getResource("blackRectangle.png"));
			    bar1.setIcon(new ImageIcon(img));
			  } catch (IOException ex) {
			  }}
		
		JButton bar2 = new JButton();
		if (mySkip>=2) {
			  try {
			    Image img = ImageIO.read(getClass().getResource("blackRectangle.png"));
			    bar2.setIcon(new ImageIcon(img));
			  } catch (IOException ex) {
			  }}
		
		JButton bar3 = new JButton();
		if (mySkip>=3) {
			  try {
			    Image img = ImageIO.read(getClass().getResource("blackRectangle.png"));
			    bar3.setIcon(new ImageIcon(img));
			  } catch (IOException ex) {
			  }}
		
		JButton bar4 = new JButton();
		if (mySkip==4) {
			  try {
			    Image img = ImageIO.read(getClass().getResource("blackRectangle.png"));
			    bar4.setIcon(new ImageIcon(img));
			  } catch (IOException ex) {
			  }}

		skipBarsBox.add(bar1);
		skipBarsBox.add(Box.createHorizontalStrut(5));
		skipBarsBox.add(bar2);
		skipBarsBox.add(Box.createHorizontalStrut(5));
		skipBarsBox.add(bar3);
		skipBarsBox.add(Box.createHorizontalStrut(5));
		skipBarsBox.add(bar4);
		
		
		Box showStarsV = Box.createVerticalBox();							//show name, show rating, season #, episode #
		Box showStarsH = Box.createHorizontalBox();							//show name, show rating (image?)
		JTextField showName = new JTextField(myEpisode.getShow().getTitle());
		showStarsH.add(showName);
		showStarsH.add(new JTextField(myEpisode.getShow().getShowRating()));
		showStarsV.add(showStarsH);
		
		//Box pic = Box.createHorizontalBox();
		//pic.paint(skipBars.getGraphics());
		titleHBox.add(skipBarsBox);
		
		//episode info
		Box summTitle = Box.createHorizontalBox();
		JTextField summTitleWords = new JTextField("Episode Summary");
		JButton editSumm = new JButton("Edit");
		JButton pubSumm = new JButton("Publish");							//hidden until edit pressed
		Box summaryBox = Box.createVerticalBox();				//changed from horizontal
		JTextArea summText = new JTextArea("");
		summText.setEditable(false);
		
		Box commentsH = Box.createHorizontalBox();							//strut
		Box commentsV = Box.createVerticalBox();
		
		summTitle.add(summTitleWords);
		summTitle.add(editSumm);
		pubSumm.setEnabled(false);
		summTitle.add(pubSumm);
		summaryBox.add(summTitle);
		summaryBox.add(summText);
		
		
		//strut
		JButton addCom = new JButton("Add comment");
		
		
		
		
		
		
	}
}
