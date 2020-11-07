package com.kevinanddennis.movieNight.service.impl;

import com.kevinanddennis.movieNight.api.tmdb.TmdbConnection;
import com.kevinanddennis.movieNight.dto.Movie;
import com.kevinanddennis.movieNight.dto.MovieAssembler;
import com.kevinanddennis.movieNight.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

  private TmdbConnection tmdbConnection;
  private MovieAssembler movieAssembler;

  @Override
  public List<Movie> getMovies() {
    return tmdbConnection.getTopRatedMovies().getResults().stream()
        .map(movieAssembler::assembleMovieFromTmdbMovie)
        .collect(Collectors.toList());
  }
}
