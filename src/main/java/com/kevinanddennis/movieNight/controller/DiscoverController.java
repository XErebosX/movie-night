package com.kevinanddennis.movieNight.controller;

import com.kevinanddennis.movieNight.service.DiscoverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class DiscoverController {

    private final DiscoverService discoverService;

    @GetMapping("/discover/{genreId}")
    public String getMovies(Model model, @PathVariable String genreId) {
        model.addAttribute("movies", discoverService.getMoviesByGenreId(genreId));
        return "movies";
    }
}
