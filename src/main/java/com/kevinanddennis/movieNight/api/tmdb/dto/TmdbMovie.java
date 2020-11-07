package com.kevinanddennis.movieNight.api.tmdb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TmdbMovie {

    private Long id;
    private String overview;
    private String title;

}
