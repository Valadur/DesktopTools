package andreasgrassl.src.parser;

import java.net.URI;
import java.net.URISyntaxException;

public class StringToURIParser {
	
	public static URI parseStringToGoogleRequestURI(String s){
		String tempString = "http://www.google.de/#q=";
		String[] request = s.split(" ");
		for(String str : request){
			tempString += str + "+";
		}
		tempString = tempString.trim().replace("\n", "");
		try {
			System.out.println(":" + tempString + ":");
			return new URI(tempString);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
