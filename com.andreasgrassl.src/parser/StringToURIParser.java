package parser;

import java.net.URI;
import java.net.URISyntaxException;

public class StringToURIParser {

	public static URI parseStringToGoogleRequestURI(String s) {
		if (s.equals("")) {
			try {
				return new URI("https://www.google.de/");
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} else {

			String tempString = "https://www.google.de/#q=";
			String[] request = s.split(" ");
			for (String str : request) {
				str = str.trim();
				if(!str.equals("")){
				tempString += str + "+";
				}
			}
			tempString = tempString.replace("\n", "");
			if (tempString.endsWith("+")){
				tempString = tempString.substring(0, tempString.length()-1);
			}
			try {
				// System.out.println(":" + tempString + ":");
				if (tempString.equals("https://www.google.de/#q=")){
					return new URI("https://www.google.de/");
				}
				else{
					return new URI(tempString);
				}
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
