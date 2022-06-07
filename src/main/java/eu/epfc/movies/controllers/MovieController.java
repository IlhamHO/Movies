package eu.epfc.movies.controllers;

import eu.epfc.movies.entities.Movie;
import eu.epfc.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("index")
    public String getMovie(Model model){
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("moviesList",movies);
        return "movies";
    }

    @GetMapping("request")
    public String getForm(Model model){
        model.addAttribute("movie",new Movie());
        return "movie-create";
    }

}
