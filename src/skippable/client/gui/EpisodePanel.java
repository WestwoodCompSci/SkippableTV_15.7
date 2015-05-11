package skippable.client.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		JTextArea summText = new JTextArea(myEpisode.getEpisodeSummary());
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
		
		
		editSumm.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				summText.setEditable(true);
				editSumm.setEnabled(false);
				pubSumm.setEnabled(true);				
			}

			public void mouseEntered(MouseEvent arg0) {}

			public void mouseExited(MouseEvent arg0) {}

			public void mousePressed(MouseEvent arg0) {}

			public void mouseReleased(MouseEvent arg0) {}
			{}
			
		});
		
		pubSumm.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				myEpisode.setEpisodeSummary(summText.getText());
				summText.setEditable(false);
				pubSumm.setEnabled(false);
				editSumm.setEnabled(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
			
		});
		
		bar1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
}
