package com.kevinanddennis.movieNight.service;

import com.kevinanddennis.movieNight.dto.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {

    List<Genre> getGenres();

}
