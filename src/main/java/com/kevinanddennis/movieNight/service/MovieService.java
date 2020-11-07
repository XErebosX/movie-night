package com.kevinanddennis.movieNight.service;

import com.kevinanddennis.movieNight.dto.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> getMovies();
}
