package skippable.client.net;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PHPPost {

	Map<String, Object> params;
	
	public PHPPost(URL url) {
		params = new HashMap<String, Object>();
	}
	
	public void add(String key, String value) {
		params.put(key, value);
	}
	
	public void send() {
		
		 
		
	}
	
}
