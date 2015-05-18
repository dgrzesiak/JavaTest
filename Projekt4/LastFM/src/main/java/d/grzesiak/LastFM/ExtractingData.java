package d.grzesiak.LastFM;
import static com.jayway.restassured.RestAssured.given;
import java.util.List;
import com.jayway.restassured.specification.RequestSpecification;
public class ExtractingData {
	RequestSpecification spec;
	RequestSpecification specLimit;
	
	public ExtractingData(RequestSpecification spec, RequestSpecification specLimit){
		this.spec = spec;
		this.specLimit = specLimit;
	}
	public String getFirstArtistFromComparison(String user1, String user2){
		return given().params("type1", "user", "type2", "user",
					"value1", user1, "value2", user2)
					.spec(specLimit)
				.when().get("?method=tasteometer.compare")
					.getBody().path("comparison.result.artists.artist.name").toString();
	}
	public String getMostPopularAlbum(String artist){
		return given().params("artist", artist)
					.spec(specLimit)
				.when().get("?method=artist.gettopalbums")
					.getBody().path("topalbums.album.name").toString();
	}
	public String getMostPopularTrack(String artist){
		return 	given().params("artist", artist)
					.spec(specLimit)
				.when().get("?method=artist.gettoptracks")
					.getBody().path("toptracks.track.name").toString();
	}
	public String getFavoriteArtist(String user){
		return given().params("user", user)
					.spec(specLimit)
				.when().get("?method=user.gettopartists")
					.getBody().path("topartists.artist.name").toString();
	}
	public String getArtistBySearchWithTrack(String track){
		return 	given().params("track", track)
					.spec(specLimit)
				.when().get("?method=track.search")
					.getBody().path("results.trackmatches.track.artist").toString();
	}
	public List<String> getSimilarArtists(String artist){
		return given().params("artist", artist)
				.spec(spec)
			.when().get("?method=artist.getsimilar")
				.getBody().path("similarartists.artist.name");
	}
	public String getSimilarArtist(String artist){
		return given().params("artist", artist)
				.spec(specLimit)
			.when().get("?method=artist.getsimilar")
				.getBody().path("similarartists.artist.name").toString();
	}
}
