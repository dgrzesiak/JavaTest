package d.grzesiak.LastFM;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;


public class LastFM_Tests{

	public static String user;
	public static String user2;
	public static String apiKey;
	public static String format;
	public static RequestSpecification spec;
	public static RequestSpecification specLimit;
	
	@BeforeClass
	public static void SetUp(){
		RestAssured.baseURI = "http://ws.audioscrobbler.com/2.0/";
		user = "potworzlybardzo";
		user2 = "angels66";
		apiKey = "e4a31927b63bd9c16d7273544ac609bf";
		format = "json";
		
		spec = new RequestSpecBuilder().addParam("api_key", apiKey).addParam("format", format).build();
		specLimit = new RequestSpecBuilder().addParam("limit", 1).addParam("api_key", apiKey).addParam("format", format).build();
	}
	
	@Test
	public void getTrackOfFavoriteArtist(){
		String artist = 
				given().params("user", user)
						.spec(specLimit)
				.when().get("?method=user.gettopartists")
						.getBody().path("topartists.artist.name").toString();
		
		given().params("artist", artist)
			.spec(spec)
		.when().get("?method=artist.gettoptracks")
		.then().body("toptracks.track[1].name", equalTo("War in Heaven"));
	}
	
	@Test
	public void getTrackOfFavoriteArtistFromTwoUsers(){
		String artist = 
				given().params("type1", "user", "type2", "user",
						"value1", user, "value2", user2)
						.spec(specLimit)
				.when().get("?method=tasteometer.compare")
						.getBody().path("comparison.result.artists.artist.name").toString();
		
		given().params("artist", artist)
			.spec(specLimit)
		.when().get("?method=artist.gettoptracks")
		.then().body("toptracks.track.name", equalTo("Welcome Home"));
	}
	
	@Test
	public void artistFromComparison(){
		given().params("type1", "user", "type2", "user",
				"value1", user, "value2", user2)
			.spec(spec)
		.when().get("?method=tasteometer.compare")
		.then().body("comparison.result.artists.artist[2].name", equalTo("Pantera"));
	}
	
	@Test
	public void artistSearch(){
		given().params("artist", "Marley")
			.spec(specLimit)
		.when().get("?method=artist.search")
		.then().body("results.artistmatches.artist.name", equalTo("Bob Marley"));
	}
	
	@Test
	public void mostPopularArtistAlbum(){
		given().params("artist", "Pink Floyd")
			.spec(spec)
		.when().get("?method=artist.gettopalbums")
		.then().body("topalbums.album.name", hasItem("The Dark Side of the Moon"));
	}
	
	@Test
	public void mostFavoriteUsersAlbums(){
		given().params("user", user)
			.spec(spec)
		.when().get("?method=user.gettopalbums")
		.then().body("topalbums.album.artist.name", hasItem("Creed"))
			.body("topalbums.album.artist[1].name", equalTo("The Black Dahlia Murder"));
	}

}
