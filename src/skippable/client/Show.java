package skippable.client;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Show extends JPanel {
	private JPanel p;
	private Show()
	{
		//create frame
		p = new JPanel();
		p.setPreferredSize(super.getSize());
		//Episode Buttons
		ArrayList<Episodes> epi = new ArrayList<Episodes>();
		 
		
		//Sliders
		int min = 0;
		int max = 100;
		int mid= 50;
		JSlider Skip = new JSlider(JSlider.HORIZONTAL,min,mid,max);
		
		
		
	
		
		//Boxes
		Box vb = Box.createVerticalBox();
		Box Title= Box.createHorizontalBox();
		Box Seasons= Box.createHorizontalBox();
		Box SeasonCompletion= Box.createHorizontalBox();
		Box Slider= Box.createHorizontalBox();
		Box Episodes= Box.createHorizontalBox();
		Box Ratings= Box.createHorizontalBox();
		Box vr1 = Box.createVerticalBox();
		Box vr2 = Box.createVerticalBox();
		Box vr3 = Box.createVerticalBox();
		Box vr4 = Box.createVerticalBox();
		
	
		for(int i = 0;i<epi.size();i++)
			epi.get(i);
		
		//p.add();

	
		p.setVisible(true);
	}
}




