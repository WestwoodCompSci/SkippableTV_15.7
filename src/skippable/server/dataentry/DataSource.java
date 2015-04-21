package skippable.server.dataentry;

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
	}

}
