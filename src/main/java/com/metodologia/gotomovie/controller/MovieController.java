package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.Cast;
import com.metodologia.gotomovie.domain.Movie;
import com.metodologia.gotomovie.domain.SearchResults;
import com.metodologia.gotomovie.service.CastService;
import com.metodologia.gotomovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// movie api: https://developers.themoviedb.org/3/getting-started/introduction
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    CastService castService;


    public SearchResults getMoviesByTitle(String title) {
        SearchResults searchResults = movieService.getMoviesByTitle(title);
        return searchResults;
    }

    /*
    @PostMapping("")
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    } */

    public Movie getMovieById(@PathVariable int id) {
        Movie movie = movieService.getMovieById(id);
        Cast cast = castService.getCastByMovieId(id);
        movie.setCast(cast.getCast());
        return movie;
    }

    public SearchResults getPopularMovies(){
        SearchResults results = movieService.getPopularMovies();
        return results;
    }


}

