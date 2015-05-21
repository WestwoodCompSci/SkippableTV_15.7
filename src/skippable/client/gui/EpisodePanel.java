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

import skippable.client.SkippableClient;
import skippable.client.backend.Episode;
import skippable.client.backend.Show;

public class EpisodePanel extends JPanel
{
	Episode myEpisode;
	int mySkip;

	
	public EpisodePanel(Episode ep)
	{
		
		
															
		myEpisode = ep;
		mySkip = myEpisode.getEpisodeSkippability();
		Box biggerBox = Box.createHorizontalBox();
		Box mainBox = Box.createVerticalBox();
		
		//TV show info		
		JTextField titleField = new JTextField(myEpisode.getTitle());
		Box titleHBox = Box.createHorizontalBox();							//contains bars, showStarsV
		/*Image skipBars = null;
		try {
			skipBars = ImageIO.read(new File("image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}							//skip bars, unique to episode
		*/
		
		Box skipBarsBox = Box.createVerticalBox();
		
		JButton bar1 = new JButton();
		if (mySkip>=1) {
			  try {
			    Image img = ImageIO.read(getClass().getResource("blackrectangle.png"));
			    bar1.setIcon(new ImageIcon(img));
			    bar1.setPreferredSize(new Dimension(10, 4));
			    bar1.setMaximumSize(new Dimension(10, 4));
			  } catch (IOException ex) {
			  }}
		
		JButton bar2 = new JButton();
		if (mySkip>=2) {
			  try {
			    Image img = ImageIO.read(getClass().getResource("blackrectangle.png"));
			    bar2.setIcon(new ImageIcon(img));
			    bar2.setPreferredSize(new Dimension(10, 4));
			    bar2.setMaximumSize(new Dimension(10, 4));
			  } catch (IOException ex) {
			  }}
		
		JButton bar3 = new JButton();
		if (mySkip>=3) {
			  try {
			    Image img = ImageIO.read(getClass().getResource("blackrectangle.png"));
			    bar3.setIcon(new ImageIcon(img));
			    bar3.setPreferredSize(new Dimension(10, 4));
			    bar3.setMaximumSize(new Dimension(10, 4));
			  } catch (IOException ex) {
			  }}
		
		JButton bar4 = new JButton();
		if (mySkip==4) {
			  try {
			    Image img = ImageIO.read(getClass().getResource("blackrectangle.png"));
			    bar4.setIcon(new ImageIcon(img));
			    bar4.setPreferredSize(new Dimension(10, 4));
			    bar4.setMaximumSize(new Dimension(10, 4));
			  } catch (IOException ex) {
			  }}

		skipBarsBox.add(bar1);
		skipBarsBox.add(Box.createHorizontalStrut(5));
		skipBarsBox.add(bar2);
		skipBarsBox.add(Box.createHorizontalStrut(5));
		skipBarsBox.add(bar3);
		skipBarsBox.add(Box.createHorizontalStrut(5));
		skipBarsBox.add(bar4);
		
		
		Box showStarsV = Box.createVerticalBox();							//showStarsH, season #, episode #
		Box showStarsH = Box.createHorizontalBox();							//show name, show rating (image?)
		JButton showName = new JButton(myEpisode.getShow().getTitle());
		showStarsH.add(showName);
		showStarsH.add(new JTextField(myEpisode.getShow().getShowRating()));
		showStarsV.add(showStarsH);
		showStarsV.add(new JTextField(myEpisode.getSeason()+"   "+myEpisode.getEpNum()));
		showStarsV.add(Box.createVerticalStrut(5));
		
		//Box pic = Box.createHorizontalBox();
		//pic.paint(skipBars.getGraphics());
		titleHBox.add(skipBarsBox);
		titleHBox.add(showStarsV);
		
		//episode info
		Box summTitle = Box.createHorizontalBox();
		JTextField summTitleWords = new JTextField("Episode Summary");
		JButton editSumm = new JButton("Edit");
		JButton pubSumm = new JButton("Publish");							//hidden until edit pressed
		Box summaryBox = Box.createVerticalBox();				//changed from horizontal
		JTextArea summText = new JTextArea(myEpisode.getEpisodeSummary());
		summText.setEditable(false);
		
		
		
		Box sumTextH = Box.createHorizontalBox();
		sumTextH.add(Box.createHorizontalStrut(10));
		sumTextH.add(summText);
		
		summTitle.add(summTitleWords);
		summTitle.add(Box.createHorizontalStrut(3));
		summTitle.add(editSumm);
		summTitle.add(Box.createHorizontalStrut(3));
		pubSumm.setEnabled(false);
		summTitle.add(pubSumm);
		summTitle.add(Box.createHorizontalStrut(3));
		summaryBox.add(summTitle);
		summaryBox.add(Box.createVerticalStrut(3));
		summaryBox.add(sumTextH);
		
		
		//strut
		//JButton addCom = new JButton("Add comment");
		
		
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
				myEpisode.addRating(1);
				
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
		
		bar2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				myEpisode.addRating(2);
				
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
		
		bar3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				myEpisode.addRating(3);
				
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
		
		bar4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				myEpisode.addRating(4);
				
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

		mainBox.add(Box.createVerticalStrut(5));
		mainBox.add(titleField);
		mainBox.add(Box.createVerticalStrut(3));
		mainBox.add(titleHBox);
		mainBox.add(Box.createVerticalStrut(5));
		mainBox.add(summaryBox);
		mainBox.add(Box.createVerticalStrut(5));
		
		biggerBox.add(Box.createHorizontalStrut(5));
		biggerBox.add(mainBox);
		biggerBox.add(Box.createHorizontalStrut(5));
		
	
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				Show s = new Show("series", "Genre", "summary");
				s.addEpisode("example", "summary summary summary fjajclkfjmhxdahjkfclnajlm", 3);
				System.out.println(s.getEpisodes().get(0).getTitle());
				new EpisodePanel(s.getEpisodes().get(0)); }
		});
	}
}
