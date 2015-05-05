package skippable.client.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import skippable.client.backend.Episode;
import skippable.client.backend.Show;

public class ShowPanel extends JPanel {
	private JPanel p;
	private int c;
	private ShowPanel()
	{
		//variables
		int rating;
		Show DasShow = null; //Change this to the chosen episode
		//create frame
		p = new JPanel();
		p.setPreferredSize(new Dimension(600,400));
		//Episode Buttons
		ArrayList<Episode> epi = new ArrayList<Episode>();
		 for(int i = 0; i < DasShow.getEpisodes().size();i++)
			 epi.set(i, DasShow.getEpisodes().get(i));
		
		//Sliders
		int min = 0;
		int max = 100;
		int mid= 50;
		JSlider Skip = new JSlider(JSlider.HORIZONTAL,min,mid,max);
		
		
		
	
		
		//Boxes
		Box vb = Box.createVerticalBox();
		Box Title= Box.createHorizontalBox();
		//Box Seasons= Box.createHorizontalBox();
		//Box SeasonCompletion= Box.createHorizontalBox();
		Box Slider= Box.createHorizontalBox();
		Box Episodes= Box.createHorizontalBox();
		Box Ratings= Box.createHorizontalBox();
		JLabel vr1 = new JLabel("");
		vr1.setBackground(Color.BLACK);
		vr1.setOpaque(true);
		JLabel vr2 = new JLabel("");
		vr2.setBackground(Color.BLACK);
		vr2.setOpaque(true);
		JLabel vr3 = new JLabel("");
		vr3.setBackground(Color.BLACK);
		vr3.setOpaque(true);
		JLabel vr4 = new JLabel("");
		vr4.setBackground(Color.BLACK);
		vr4.setOpaque(true);
	
		
		for(int i = 0;i<epi.size();i++)
		{
			JButton episodenum = new JButton("Ep. " + (i+1));
			c = i;
			
			episodenum.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
			
					 EpisodePanel e = new EpisodePanel(DasShow.getEpisodes().get(c));
					p.setVisible(false);
					e.setVisible(true);
				}});
			rating = epi.get(i).getEpisodeSkippability();
			Box sho = Box.createVerticalBox();
			Box epis = Box.createHorizontalBox();
			Box title = Box.createHorizontalBox();
			JLabel episo = new JLabel(epi.get(i).getTitle());
			
			if(rating == 1)
			{
				episo.setBackground(Pick(Skip.getValue(),1));
				vr1.setText("SKIP IT!!!");
				epis.add(vr1);
				title.add(episo);
				sho.add(title);
				sho.add(epis);
				
			}
			else
			if(rating == 2)
			{
				episo.setBackground(Pick(Skip.getValue(),2));
				vr2.setText("maybe skip");
				epis.add(vr1);
				epis.add(vr2);
				title.add(episo);
				sho.add(title);
				sho.add(epis);
				
			}
			else
			if(rating == 3)
			{
				episo.setBackground(Pick(Skip.getValue(),3));
				vr3.setText("dont skip");
				epis.add(vr1);
				epis.add(vr2);
				epis.add(vr3);
				title.add(episo);
				sho.add(title);
				sho.add(epis);
				
			}
			else
			if(rating == 4)
			{
				episo.setBackground(Pick(Skip.getValue(),4));
				vr4.setText("NEVER SKIP!!!");
				epis.add(vr1);
				epis.add(vr2);
				epis.add(vr3);
				epis.add(vr4);
				title.add(episo);
				sho.add(title);
				sho.add(epis);
				
			}
			Ratings.add(sho);
			Box thisSode = Box.createVerticalBox();
			thisSode.add(episodenum);
			thisSode.add(Ratings);
			Episodes.add(thisSode);	
		}
		
		Slider.add(Skip);
		Title.add(new JLabel(DasShow.getTitle()));
		TextArea summary = new TextArea();
		summary.setText(DasShow.getShowSummary());
		Title.add(summary);
		
		vb.add(Title);
		vb.add(Slider);
		vb.add(Episodes);
		p.add(vb);

	
		p.setVisible(true);
	}
	public Color Pick(int Per, int r)
	{
		if(r == 1)
			return Color.RED;
		if((Per<50)&&(r ==2))
			return Color.RED;
		if((Per<75)&&(r ==3))
			return Color.RED;
		return Color.GREEN;
	}
	
}




