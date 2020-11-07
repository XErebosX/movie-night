package com.kevinanddennis.movieNight.api.impl;

import com.kevinanddennis.movieNight.api.ApiConnection;
import com.kevinanddennis.movieNight.config.MovieNightProperties;
import com.kevinanddennis.movieNight.dto.DiscoverResponse;
import com.kevinanddennis.movieNight.dto.Movie;
import com.kevinanddennis.movieNight.dto.TmdbGenres;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Component
public class TmdbConnectionImpl implements ApiConnection {

  private final RestTemplate restTemplate;

  public TmdbConnectionImpl(MovieNightProperties movieNightProperties) {
    this.restTemplate = new RestTemplate();
    this.movieNightProperties = movieNightProperties;
  }

  private final MovieNightProperties movieNightProperties;

  @Override
  public List<Movie> getMovies() {
    String url = "";

    return restTemplate
        .exchange(url, GET, createHeader(), new ParameterizedTypeReference<List<Movie>>() {})
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
