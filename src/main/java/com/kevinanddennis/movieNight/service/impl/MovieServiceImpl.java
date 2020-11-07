package com.kevinanddennis.movieNight.service.impl;

import com.kevinanddennis.movieNight.api.impl.RapidConnectionImpl;
import com.kevinanddennis.movieNight.dto.Movie;
import com.kevinanddennis.movieNight.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private RapidConnectionImpl rapidConnection;

    @Override
    public List<Movie> getMovies() {
        return rapidConnection.getMovies();
    }
}
