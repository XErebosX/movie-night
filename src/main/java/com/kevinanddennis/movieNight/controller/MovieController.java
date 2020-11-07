package com.kevinanddennis.movieNight.controller;

import com.kevinanddennis.movieNight.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public String getMovies(Model model) {
        model.addAttribute("movies", movieService.getMovies());
        return "movies";
    }
}
