package d.grzesiak.LastFM;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;


public class LastFM_Tests{

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
	public void getTrackOfFavoriteArtist(){
		String artist = data.getFavoriteArtist(user1);
		
		given().params("artist", artist)
			.spec(specLimit)
		.when().get("?method=artist.gettoptracks")
		.then().body("toptracks.track.name", equalTo("Burn"));
	}
	@Test
	public void getTrackOfFavoriteArtistFromTwoUsers(){
		String artist = data.getFirstArtistFromComparison(user1, user2);
		
		given().params("artist", artist)
			.spec(specLimit)
		.when().get("?method=artist.gettoptracks")
		.then().body("toptracks.track.name", equalTo("Blow Your Trumpets Gabriel"));
	}
	@Test
	public void artistFromComparison(){
		given().params("type1", "user", "type2", "user",
				"value1", user1, "value2", user2)
			.spec(specLimit)
		.when().get("?method=tasteometer.compare")
		.then().body("comparison.result.artists.artist.name", equalTo("Behemoth"));
	}
	@Test
	public void artistBySearchingTrack(){
		given().params("track", "Domination")
			.spec(spec)
		.when().get("?method=track.search")
		.then().body("results.trackmatches.track.artist", hasItem("Pantera"));
	}
	@Test
	public void mostPopularArtistAlbum(){
		given().params("artist", "kat")
			.spec(specLimit)
		.when().get("?method=artist.gettopalbums")
		.then().body("topalbums.album.name", equalTo("Ballady"))
			.statusCode(200);
	}
	@Test
	public void mostPopularArtistTrack(){
		given().params("artist", "iwrestledabearonce")
			.spec(specLimit)
		.when().get("?method=artist.gettoptracks")
		.then().body("toptracks.track.name", equalTo("Tastes Like Kevin Bacon"));
	}
	@Test
	public void mostFavoriteUsersArtist(){
		given().params("user", user1)
			.spec(specLimit)
		.when().get("?method=user.gettopartists")
		.then().body("topartists.artist.name", equalTo("Septicflesh"))
			.statusCode(200);
	}
}
