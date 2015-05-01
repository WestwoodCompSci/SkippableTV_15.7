package skippable.client.backend;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class Show {

	private String summary;
	private int rating;
	private String genre;
	
	
	private Image img;
	private String title;
	private List<Episode> episodes;
	
	
	public Show(String name, String genre, String summary) {
		this.title = name;
		this.genre = genre;
		this.summary = summary;
	}
	
	public String getShowSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void rateShow(int r) {
		rating = r;
	}
	
	public int getShowRating() {
		return rating;
	}
	public Image getImage() {
		return img;
	}
	
	public void setImage(Image image) {
		img = image;
	}
	
	/**
	 * 
	 * Reads an image from a source string.
	 * 
	 * @param source - path to image file
	 * @throws IOException - if the image file doesn't exist or can't be read
	 */
	public void readImage(String source) throws IOException {
		setImage(ImageIO.read(new File(source)));
	}
	
	public String getGenre() {
		return genre;
	}
	
	public List<Episode> getEpisodes() {
		return episodes;
	}
	
	public String getTitle() {
		return title;
	}
	
}
