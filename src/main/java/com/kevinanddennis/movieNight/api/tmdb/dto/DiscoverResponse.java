package com.kevinanddennis.movieNight.api.tmdb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiscoverResponse {

  private int page;
  private List<TmdbMovie> results;
}
