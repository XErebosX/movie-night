package com.kevinanddennis.movieNight.api.tmdb;

import com.kevinanddennis.movieNight.api.tmdb.dto.TmdbMovie;
import com.kevinanddennis.movieNight.api.tmdb.dto.TopRatedResponse;
import com.kevinanddennis.movieNight.config.MovieNightProperties;
import com.kevinanddennis.movieNight.api.tmdb.dto.DiscoverResponse;
import com.kevinanddennis.movieNight.api.tmdb.dto.TmdbGenres;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Component
public class TmdbConnection {

  private final RestTemplate restTemplate;

  public TmdbConnection(MovieNightProperties movieNightProperties) {
    this.restTemplate = new RestTemplate();
    this.movieNightProperties = movieNightProperties;
  }

  private final MovieNightProperties movieNightProperties;

  public TopRatedResponse getTopRatedMovies() {
    String url = movieNightProperties.getTmdbBaseUrl() + "/movie/top_rated";

    return restTemplate
        .exchange(url, GET, createHeader(), TopRatedResponse.class)
        .getBody();
  }

  public TmdbGenres getGenres() {
    String url = movieNightProperties.getTmdbBaseUrl() + "/genre/movie/list";

    return restTemplate.exchange(url, GET, createHeader(), TmdbGenres.class).getBody();
  }

  public DiscoverResponse discoverMoviesByGenreId(String genreId) {
    String url = movieNightProperties.getTmdbBaseUrl() + "/discover/movie?with_genres=" + genreId;

    return restTemplate.exchange(url, GET, createHeader(), DiscoverResponse.class).getBody();
  }

  private HttpEntity createHeader() {
    String accessToken =
        "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3YjM2ZDIzNTMwNzc0NDljNDJmZWQ0Yzg4ODk5MmRjMyIsInN1YiI6IjVmYTZlYmUzMjE2MjFkMDAzZWY1NzZjZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.otaKlnJF4Ydbge5r9dVEDAt93GnDlnzxri8nXNSme2Y";

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + accessToken);

    HttpEntity httpEntity = new HttpEntity(headers);
    return httpEntity;
  }
}
