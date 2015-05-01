package skippable.client.backend;

import java.util.ArrayList;
import java.util.List;

public class Show {

	private String summary;
	private int rating;
	private String genre;
	private String title;
	
	private ArrayList<Episode> episodes;
	
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
	
	public String getTitle() {
		return title;
	}
	
	public ArrayList<Episode> getEpisodes() {
		return episodes;
	}
	
}
