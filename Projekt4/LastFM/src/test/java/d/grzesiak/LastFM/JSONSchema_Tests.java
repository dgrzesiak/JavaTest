package d.grzesiak.LastFM;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

public class JSONSchema_Tests{

	public static String artist;
	public static String album;
	public static String apiKey;
	public static String format;
	public static RequestSpecification spec;

	
	@BeforeClass
	public static void SetUp(){
		RestAssured.baseURI = "http://ws.audioscrobbler.com/2.0/";
		artist = "Pantera";
		album = "Cowboys from Hell";
		apiKey = "e4a31927b63bd9c16d7273544ac609bf";
		format = "json";
		
		spec = new RequestSpecBuilder().addParam("api_key", apiKey).addParam("format", format).build();
	}
	
	@Test
	public void topArtistsSchemaValidation(){
		given().params("artist", artist, "album", album)
			.spec(spec)
		.when().get("?method=album.getinfo")
		.then().body(matchesJsonSchemaInClasspath("albumGetInfoSchema.json"))
			.statusCode(200);
	}
}