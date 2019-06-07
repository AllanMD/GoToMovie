package com.metodologia2.gotomovie.controller;

import com.metodologia2.gotomovie.Service.MovieService;
import com.metodologia2.gotomovie.domain.Movie;
import com.metodologia2.gotomovie.domain.SearchResults;
import com.metodologia2.gotomovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// movie api: https://developers.themoviedb.org/3/getting-started/introduction
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    MovieService movieService = new MovieService(); // ver esto

    @GetMapping("")
    public Movie getMovie(){
        return new Movie();
    }

    @GetMapping("search/{title}")
    public SearchResults getMoviesByTitle(@PathVariable String title) {
        RestTemplate restTemplate = new RestTemplate();
        SearchResults searchResults = movieService.getMoviesByTitle(title);
        return searchResults;
    }

    @PostMapping("")
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+id+"?api_key=8d7db92be0746d3da167842d227f2f64&language=en-US", Movie.class);
    }
}
