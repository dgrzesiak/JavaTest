package d.grzesiak.LastFM;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

public class JSONSchema_Tests{

	public static String user1;
	public static String user2;
	public static String apiKey;
	public static String format;
	public static RequestSpecification spec;
	public static RequestSpecification specLimit;
	public static ExtractingData data;
	
	@BeforeClass
	public static void SetUp(){
		RestAssured.baseURI = "http://ws.audioscrobbler.com/2.0/";
		user1 = "potworzlybardzo";
		user2 = "patwor123";
		apiKey = "e4a31927b63bd9c16d7273544ac609bf";
		format = "json";
		
		spec = new RequestSpecBuilder().addParam("api_key", apiKey).addParam("format", format).build();
		specLimit = new RequestSpecBuilder().addParam("limit", 1).addParam("api_key", apiKey).addParam("format", format).build();
		data = new ExtractingData(spec, specLimit);
	}
	
	@Test
	public void topArtistsSchemaValidation(){
		given().param("user", user1)
			.spec(specLimit)
		.when().get("?method=album.getinfo")
		.then().body(matchesJsonSchemaInClasspath("albumGetInfoSchema.json"));
	}
}