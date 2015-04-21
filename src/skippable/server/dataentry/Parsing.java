package skippable.server.dataentry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

public class Parsing {
	private List<EpisodeData> results;
	
	public Parsing(){
		results = new ArrayList<EpisodeData>();
	}
	
	public HashMap fill(String response){
		Gson g = new Gson();
		Parsing p = g.fromJson(response, Parsing.class);
		HashMap<Integer, EpisodeData> hm = new HashMap<Integer,EpisodeData>();
		for(EpisodeData ed: p.results){
		  hm.put(ed.id, ed);  
		}
		return hm;
	}

}
