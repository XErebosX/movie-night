package com.kevinanddennis.movieNight.api.tmdb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopRatedResponse {

    private List<TmdbMovie> results;

}
