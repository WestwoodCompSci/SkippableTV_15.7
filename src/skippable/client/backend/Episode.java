package skippable.client.backend;

import java.util.List;

public class Episode {

	private String title;
	private String summary;
	private int userRatingNum;
	private int averageRating;
	private Show show;
	private List<String> comments;
	private int season;
	private int episodeNum;

	
	public Episode(Show show, String title, String summary, int rating) {
		this.title = title;
		this.show = show;
		this.summary = summary;
		this.averageRating = rating;
		userRatingNum = 0;				//does this work?
		averageRating = 0;				//^
	}
	
	public int getEpisodeSkippability() {
		return averageRating;
	}
	
	public String getEpisodeSummary() {
		return summary;
	}
	
	public void setEpisodeSummary(String summary) {
		this.summary = summary;
	}
	
	public void addRating(int rating) {
		if (rating < 1 || rating > 4) {
			throw new IllegalArgumentException("Rating must be from 1-4!");
		}
		
		userRatingNum++;
		averageRating = (averageRating+rating)/userRatingNum;
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addComment(String comment) {
		comments.add(comment);
	}
	
	public Show getShow() {
		return show;
	}
	
	public int getSeason() {
		return season;
	}
	
	public int getEpNum() {
		return episodeNum;
	}
	
}
