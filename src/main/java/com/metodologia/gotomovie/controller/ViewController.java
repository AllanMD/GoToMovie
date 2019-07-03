package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.Actor;
import com.metodologia.gotomovie.domain.Comment;
import com.metodologia.gotomovie.domain.Movie;
import com.metodologia.gotomovie.domain.SearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class ViewController {

    @Autowired
    MovieController movieController;

    @Autowired
    CommentController commentController;

    @Autowired
    ScoreController scoreController;


    @GetMapping({"/home",  "/", ""})
    public ModelAndView homeView() {
        ModelAndView model = new ModelAndView();
        SearchResults popularMovies = movieController.getPopularMovies();
        model.addObject("popularMovies", popularMovies.getResults());
        model.addObject("movie", new Movie()); // para la busqueda de peliculas
        model.setViewName("home"); // cambiar a home comun despues //home 2 es para probar y si funciona bien pasa a ser home
        return model;
    }

    @GetMapping("movie/search")
    public ModelAndView getMoviesByTitle(String title) {
        RestTemplate restTemplate = new RestTemplate();
        SearchResults searchResults = movieController.getMoviesByTitle(title);
        List<Movie> movies = new ArrayList<Movie>();
        searchResults.getResults().forEach(movie -> {
            movies.add(movie);
        });
        ModelAndView model = new ModelAndView();
        model.addObject("movies", movies);
        model.addObject("movie", new Movie());
        model.setViewName("movies-results");
        return model;
    }

    @GetMapping("movie/searchById/{id}")
    public ModelAndView searchById(@PathVariable int id) {
        Movie movie = movieController.getMovieById(id);
        List<Comment> comments = commentController.getLatestCommentsByMovieId(id);
        String averageScore = scoreController.getAverageScoreByMovie(id);
        System.out.println(movie.toString());
        ModelAndView model = new ModelAndView();
        model.addObject("movie",movie);
        model.addObject("comments", comments);
        model.addObject("averageScore",averageScore);
        model.setViewName("movie-single");
        return model;
    }

    @GetMapping("template")
    public ModelAndView templateView() {
        ModelAndView model = new ModelAndView();
        model.setViewName("template");
        return model;
    }

}
