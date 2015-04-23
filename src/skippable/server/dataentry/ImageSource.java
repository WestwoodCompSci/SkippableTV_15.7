package skippable.server.dataentry;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.lang.model.util.Elements;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import com.google.gson.*;

public class ImageSource 
{
	
	private String imagesource;
	private String google;
	private String query;
	Elements links;
	private String imgSrc;
	
	
	//uses google to find an image related to the input, goes to first website and takes first image
	//get image method returns the image taken from the website
	
	public ImageSource(String input) throws IOException
	{
		google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
	    String search =input;
	    String charset = "UTF-8";
	    URL url = new URL(google + URLEncoder.encode(search, charset));
	    
	    Reader reader = new InputStreamReader(url.openStream(), charset);
	    
	    GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);
	    
	    String firstresult=results.getResponseData().getResults().get(0).getUrl();
	    
	    URL website=new URL(firstresult);
	    URLConnection connection= website.openConnection();
	    
	    InputStream is = connection.getInputStream();
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader br = new BufferedReader(isr);
	    
	    HTMLEditorKit htmlKit = new HTMLEditorKit();
	    HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
	    HTMLEditorKit.Parser parser = new ParserDelegator();
	    HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
	    parser.parse(br, callback, true);
	    
	    HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.IMG);
	    if(iterator.isValid()){
	    	iterator.next();
	    	
	    	
	    	imgSrc = (String) iterator.getAttributes().getAttribute(HTML.Attribute.SRC);
	    	
	    }
	    
	    
	    
	    //String imagesource= website+"#/media/File:"+imgSrc; (test code)
	    imagesource ="http:"+imgSrc;
	    System.out.println(imagesource);
	    
	    RenderedImage image= ImageIO.read(new URL(imagesource));
	    File joe=new File("image.png");
	    ImageIO.write(image,"jpg",joe);
	}
	
	 public static void main(String args[]) throws Exception
	 {
		 new ImageSource("smiley face");
	 }

	public Image getimage() throws MalformedURLException, IOException
	{
		return ImageIO.read(new URL(imagesource));
	}
}
