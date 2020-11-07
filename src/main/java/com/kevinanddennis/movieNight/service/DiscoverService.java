package com.kevinanddennis.movieNight.service;

import com.kevinanddennis.movieNight.dto.Movie;

import java.util.List;

public interface DiscoverService {

    List<Movie> getMoviesByGenreId(String genreId);

}
