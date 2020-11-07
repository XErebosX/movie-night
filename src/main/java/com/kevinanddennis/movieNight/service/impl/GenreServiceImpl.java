package com.kevinanddennis.movieNight.service.impl;

import com.kevinanddennis.movieNight.api.tmdb.TmdbConnection;
import com.kevinanddennis.movieNight.dto.Genre;
import com.kevinanddennis.movieNight.dto.GenreAssembler;
import com.kevinanddennis.movieNight.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

  private TmdbConnection tmdbConnection;
  private GenreAssembler genreAssembler;

  @Override
  public List<Genre> getGenres() {
    return tmdbConnection.getGenres().getGenres().stream()
        .map(genreAssembler::assembleGenreFromTmdbGenre)
        .collect(Collectors.toList());
  }
}
