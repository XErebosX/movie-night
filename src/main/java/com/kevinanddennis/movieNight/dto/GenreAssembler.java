package com.kevinanddennis.movieNight.dto;

import com.kevinanddennis.movieNight.api.tmdb.dto.TmdbGenre;
import org.springframework.stereotype.Component;

@Component
public class GenreAssembler {

    public Genre assembleGenreFromTmdbGenre(TmdbGenre tmdbGenre) {
        return Genre.builder().id(tmdbGenre.getId()).name(tmdbGenre.getName()).build();
    }
}
