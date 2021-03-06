package skippable.server.dataentry;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.imageio.ImageIO;

public abstract class DataSource {
	
	//Abstract Methods
	public abstract EpisodeData getDataOnSeries(String series);
	public abstract EpisodeData getDataOnEpisode(String series, int episode);
	
	//Database methods
	public void addToDataBase(String series){
		addToDataBase(getDataOnSeries(series));
	}
	
	public void addToDataBase(String series, int episode){
		addToDataBase(getDataOnEpisode(series,episode));
	}
	
	public void addToDataBase(EpisodeData data){
		//TODO: implement data entry in database once database gets an implementation prepared
		EpisodeData test = new EpisodeData();
		System.out.println(test.description);
	}
	
	
	//get image method uses url from database that links to an image and returns the actual image
	public Image getimage(String inputurl) 
	{
		
		try {
			return ImageIO.read(new URL(inputurl));
		} catch (MalformedURLException e) {
			// TODO fail
			
		} catch (IOException e) {
			// TODO fail
			
		}
		return null;
	}

}
