package com.kevinanddennis.movieNight.api.impl;

import com.kevinanddennis.movieNight.api.ApiConnection;
import com.kevinanddennis.movieNight.dto.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RapidConnectionImpl implements ApiConnection {
    @Override
    public List<Movie> getMovies() {
        return null;
    }
}
