package skippable.server.dataentry;

public class EpisodeData {
	
	//Class to hold GSON stream built from JSON responses from TMDB
	//This is only designed for TMDB data, other data entry sources may need separate classes depending on structure

	//Constants used to represent fields that do not yet have data
	static final int    UNKNOWNINT    = -1;
	static final String UNKNOWNSTRING = "?"; 
	static final Float  UNKNOWNFLOAT  = -1f;
	
	//Main data info fields
	//NOTE DATA FIELD NAMES ARE NONARBITRARY, MUST MATCH NAMES OF INCOMING JSON DATA FIELDS, DO NOT REFACTOR DATA FIELD NAMES!
	public String name, original_name, description, backdrop_path, poster_path, first_air_date;
	public int season, id, vote_count; 
	public float vote_average, popularity;
	
	public EpisodeData(){
		//Makes no assumptions about what data is known, just creates a shell
		name           = UNKNOWNSTRING;
		original_name  = UNKNOWNSTRING;
		description    = UNKNOWNSTRING;
		backdrop_path  = UNKNOWNSTRING;
		poster_path    = UNKNOWNSTRING;
		first_air_date = UNKNOWNSTRING;
		id         = UNKNOWNINT;
		vote_count = UNKNOWNINT; 
		vote_average = UNKNOWNFLOAT;
		popularity   = UNKNOWNFLOAT;
	}

}
