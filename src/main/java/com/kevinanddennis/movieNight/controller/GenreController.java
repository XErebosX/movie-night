package com.kevinanddennis.movieNight.controller;

import com.kevinanddennis.movieNight.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class GenreController {

    private GenreService genreService;

    @GetMapping("/genres")
    public String getGenres(Model model){
        model.addAttribute("genres", genreService.getGenres());
        return "genres";
    }

}
