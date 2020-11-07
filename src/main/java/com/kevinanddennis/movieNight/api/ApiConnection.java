package com.kevinanddennis.movieNight.api;

import com.kevinanddennis.movieNight.dto.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApiConnection {

    List<Movie> getMovies();
}
