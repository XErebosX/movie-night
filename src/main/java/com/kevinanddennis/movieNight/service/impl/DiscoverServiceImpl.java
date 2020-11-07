package com.kevinanddennis.movieNight.service.impl;

import com.kevinanddennis.movieNight.api.tmdb.TmdbConnection;
import com.kevinanddennis.movieNight.dto.Movie;
import com.kevinanddennis.movieNight.dto.MovieAssembler;
import com.kevinanddennis.movieNight.service.DiscoverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiscoverServiceImpl implements DiscoverService {

    private final TmdbConnection tmdbConnection;
    private final MovieAssembler movieAssembler;

    @Override
    public List<Movie> getMoviesByGenreId(String genreId) {
        return tmdbConnection.discoverMoviesByGenreId(genreId).getResults().stream()
                .map(movieAssembler::assembleMovieFromTmdbMovie)
                .collect(Collectors.toList());
    }
}
