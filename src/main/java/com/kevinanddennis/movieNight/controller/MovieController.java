package com.kevinanddennis.movieNight.controller;

import com.kevinanddennis.movieNight.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public String getMovies(Model model){
        model.addAttribute("movie", movieService.getMovies());
        return "movies";
    }
}
