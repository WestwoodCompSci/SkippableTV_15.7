package skippable.server.dataentry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class TheMovieDB extends DataSource {
	
	/**
	 * 
	 * Pulls content from themoviedb.org
	 * Note the following maximum constraints that could effect future scalability:
	 * 30 requests every 10 seconds per IP
	 * AND a maximum 20 simultaneous connections per IP
	 * Exceeding these limits will result in an error 503, deliberate from TMDB
	 * 
	 * Uses TMDB official DB
	 * Based on documentation available at: http://docs.themoviedb.apiary.io/#reference 
	 * Note reference on status codes: https://www.themoviedb.org/documentation/api/status-codes
	 */
	
	private final String APIKEY = "cd1e026ff4a9b8d78ee697f781755973";
	
	
	@Override
	public EpisodeData getDataOnSeries(String series) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EpisodeData getDataOnEpisode(String series, int episode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<EpisodeData> getTvID(String title){
		String baseUrl = "https://api.themoviedb.org/3/search/tv";
		String query = "?query="+title.replaceAll(" ", "%20");
		String apikey = "&api_key=cd1e026ff4a9b8d78ee697f781755973";
		String URL = baseUrl + query + apikey;
		
		String content = readUrl(URL);
		
		System.out.println("Full JSON content received: \n" + content);
		
		System.out.println("\nParsed usable information:\n");
		
		Parsing p = new Parsing();
		
		System.out.println(p.fill(content));
		return null;
	}
	
	private String readUrl(String url){
		String toRet = "";
		try {
			URL page = new URL(url);
			BufferedReader in = new BufferedReader(
			new InputStreamReader(page.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			    toRet+=inputLine;
			in.close();
		} catch (Exception e) {
			//Bleheheh, Darn it
		}
		return toRet;
		
	}
	
	public static void main(String[] args){
		TheMovieDB tmdb = new TheMovieDB();
		tmdb.getTvID("The Office");
	}
	
	
	
	

}
