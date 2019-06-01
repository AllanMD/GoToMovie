package com.metodologia2.gotomovie.controller;

import com.metodologia2.gotomovie.Service.MovieService;
import com.metodologia2.gotomovie.domain.Movie;
import com.metodologia2.gotomovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    MovieService movieService;

    @GetMapping
    public Movie getMovie(){
        return new Movie();
    }

    @GetMapping("/{title}")
    public Movie getMovie(@PathVariable String title) {
        Movie m = movieService.getMovieByTitle(title);
        return m;
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }
}
