package skippable.client.backend;

import java.util.List;

public class Episode {

	private String title;
	private String summary;
	private int userRating;
	private int averageRating;
	private Show show;
	private List<String> comments;
	private int season;
	private int episodeNum;
	
	public Episode(String title, String summary, int rating) {
		this.title = title;
		this.summary = summary;
		this.averageRating = rating;
	}
	
	public int getEpisodeSkippability() {
		// TODO implement.
		return -1;
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
		
		// TODO implement
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
