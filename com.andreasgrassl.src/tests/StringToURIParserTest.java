package tests;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import parser.StringToURIParser;

public class StringToURIParserTest {

	@Test
	public void test1() throws URISyntaxException {
		assertEquals(new URI("https://www.google.de/#q=test"), StringToURIParser.parseStringToGoogleRequestURI("test"));
	}
	
	@Test
	public void test2() throws URISyntaxException {
		assertEquals(new URI("https://www.google.de/#q=test+und+so+weiter"), StringToURIParser.parseStringToGoogleRequestURI("test und so weiter"));
	}
	
	@Test
	public void test3() throws URISyntaxException {
		assertEquals(new URI("https://www.google.de/"), StringToURIParser.parseStringToGoogleRequestURI(""));
	}
	
	@Test
	public void test4() throws URISyntaxException {
		assertEquals(new URI("https://www.google.de/#q=ThIs+Is+A+tEsT"), StringToURIParser.parseStringToGoogleRequestURI("ThIs Is A tEsT"));
	}
	
	@Test
	public void test5() throws URISyntaxException {
		assertEquals(new URI("https://www.google.de/#q=Hört+sich+das+Deutsch+an?+!"), StringToURIParser.parseStringToGoogleRequestURI("Hört sich das Deutsch an? !"));
	}
	
	@Test
	public void test6() throws URISyntaxException {
		assertEquals(new URI("https://www.google.de/#q=Spaces+and+Tabs"), StringToURIParser.parseStringToGoogleRequestURI("	  	Spaces   and 	Tabs		"));
	}
	
	@Test
	public void test7() throws URISyntaxException {
		assertEquals(new URI("https://www.google.de/#q=random+test"), StringToURIParser.parseStringToGoogleRequestURI("random test"));
	}

}
