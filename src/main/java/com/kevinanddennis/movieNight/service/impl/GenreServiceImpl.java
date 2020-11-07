package com.kevinanddennis.movieNight.service.impl;

import com.kevinanddennis.movieNight.api.impl.TmdbConnectionImpl;
import com.kevinanddennis.movieNight.dto.Genre;
import com.kevinanddennis.movieNight.dto.TmdbGenres;
import com.kevinanddennis.movieNight.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

  private TmdbConnectionImpl tmdbConnection;

  @Override
  public List<Genre> getGenres() {
    TmdbGenres genres = tmdbConnection.getGenres();
    return genres.getGenres();
  }
}
