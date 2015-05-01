package skippable.client.net;

import java.net.MalformedURLException;
import java.net.URL;

public class PHPInterface {

	URL url;
	
	public PHPInterface(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
