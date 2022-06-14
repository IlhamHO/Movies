package eu.epfc.movies.controllers;

import eu.epfc.movies.entities.Movie;
import eu.epfc.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("index")
    public String getMovie(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int p,
                           @RequestParam(value = "size",defaultValue = "5") int s,
                           @RequestParam(value = "keyword",defaultValue = "")String kw){
        Pageable paging = PageRequest.of(p,s);
        Page<Movie> moviesPage = movieRepository.search("%"+kw+"%", paging);
        model.addAttribute("moviesList",moviesPage.getContent());
        int[] pages = new int[moviesPage.getTotalPages()];
        model.addAttribute("pages",pages);
        model.addAttribute("size",s);
        model.addAttribute("currentPage",p);
        model.addAttribute("keyword",kw);
        return "movies";
    }

    @GetMapping("request")
    public String getForm(Model model){
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movie",new Movie());
        return "movie-create";
    }

    @PostMapping("request")
    public String postForm(Movie movie){
        movieRepository.save(movie);
        return "redirect:index";
    }

    @GetMapping("edit")
    public String edit(Long id, Model model){
        Optional<Movie> movie = movieRepository.findById(id);
            model.addAttribute("movie",movie.get());
        return "update-movie";
    }

    @GetMapping("delete")
    public String delete(Long id, String keyword, int page, int size){
        movieRepository.deleteById(id);
        return "redirect:index?page="+page+"&size"+size+"&keyword="+keyword;
    }

}
