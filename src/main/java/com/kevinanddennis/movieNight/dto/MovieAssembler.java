package com.kevinanddennis.movieNight.dto;

import com.kevinanddennis.movieNight.api.tmdb.dto.TmdbMovie;
import org.springframework.stereotype.Component;

@Component
public class MovieAssembler {

  public Movie assembleMovieFromTmdbMovie(TmdbMovie tmdbMovie) {
    return Movie.builder()
        .id(tmdbMovie.getId())
        .title(tmdbMovie.getTitle())
        .overview(tmdbMovie.getOverview())
        .build();
  }
}
