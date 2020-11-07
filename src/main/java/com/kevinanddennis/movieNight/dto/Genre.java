package com.kevinanddennis.movieNight.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Genre {

  private int id;
  private String name;
}
