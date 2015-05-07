package skippable.client.net;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * 
 * @author s510859
 *
 */
public class PHPInterface {

	private String params;
	private String path;
	private static final String DEFAULT_DOMAIN = "http://bytor.atwebpages.com";
	public static final String DEFAULT_REGISTER = DEFAULT_DOMAIN+"/authentication/addaccount.php";
	public static final String DEFAULT_LOGIN = DEFAULT_DOMAIN+"/authentication/login.php";
	
	
	/**
	 * 
	 * Create a new PHPInterface object to use GET or POST with PHP.
	 * 
	 * For default values, 
	 * 
	 * @param url - URL to php script
	 */
	public PHPInterface(String url) {
		params = "";
		path = url;
	}
	
	/**
	 * 
	 * Add a key, value pair to the parameters.
	 * 
	 * @param key
	 * @param value
	 */
	public void add(String key, String value) {
		if (params.length() > 0) params += "&";
		params += key + "=" + value;
	}
	
	/**
	 * 
	 * Uses POST to send parameters and fetch a response.
	 * 
	 * @return the response from the server
	 * @throws IOException - something bad happened
	 */
	public String post() throws IOException {
		
		URL url = new URL(path);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		byte[] paramBytes = params.getBytes(Charset.forName("UTF-8"));
		
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestMethod("POST");
		
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("charset", "utf-8");
		con.setRequestProperty("Content-Length", Integer.toString(paramBytes.length));
		con.setUseCaches(false);
		
		con.getOutputStream().write(paramBytes);
		con.getOutputStream().flush();
		
		Scanner in = new Scanner(new InputStreamReader(con.getInputStream(), "UTF-8"));
		
		String response = "";
		
		while(in.hasNextLine()) {
			response += in.nextLine() + "\n";
		}
		
		in.close();

		return response;
		
	}
	
	/**
	 * 
	 * Uses GET to send parameters and get a response.
	 * 
	 * @return response from php script
	 * @throws IOException - if the stream could not be opened
	 */
	public String get() throws IOException {

		
		String s = path + "?" + params;
		
		URL url = new URL(s);
		
		Scanner in = new Scanner(url.openStream());
		
		String response = "";
		
		while(in.hasNextLine()) {
			response += in.nextLine() + "\n";
		}
		
		in.close();
		
		return response;
	}
	
}
