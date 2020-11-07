package com.kevinanddennis.movieNight.service.impl;

import com.kevinanddennis.movieNight.api.impl.TmdbConnectionImpl;
import com.kevinanddennis.movieNight.dto.Movie;
import com.kevinanddennis.movieNight.service.DiscoverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiscoverServiceImpl implements DiscoverService {

    private TmdbConnectionImpl tmdbConnection;

    @Override
    public List<Movie> getMoviesByGenreId(String genreId) {
        return tmdbConnection.discoverMoviesByGenreId(genreId).getResults();
    }
}
