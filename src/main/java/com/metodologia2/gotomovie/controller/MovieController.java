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
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    MovieService movieService;

    @GetMapping("")
    public Movie getMovie(){
        return new Movie();
    }

    @GetMapping("/{title}")
    public Movie getMovie(@PathVariable String title) {
        Movie m = movieService.getMovieByTitle(title);
        return m;
    }

    @PostMapping("")
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    @GetMapping("/api")
    public Movie getMovieApi() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.themoviedb.org/3/movie/329996?api_key=8d7db92be0746d3da167842d227f2f64&language=en-US", Movie.class);
    }
}
