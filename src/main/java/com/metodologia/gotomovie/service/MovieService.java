package com.metodologia.gotomovie.service;

import com.metodologia.gotomovie.domain.Movie;
import com.metodologia.gotomovie.domain.SearchResults;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {



    // recibimos el titulo, metemos el titulo en la url
    public SearchResults getMoviesByTitle (String title){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.themoviedb.org/3/search/movie?api_key=8d7db92be0746d3da167842d227f2f64&language=en-US&query="+title+"&page=1&include_adult=false", SearchResults.class);
        // link para hacer peticion:
        //https://api.themoviedb.org/3/search/movie?api_key=8d7db92be0746d3da167842d227f2f64&language=en-US&query=dumbo&page=1&include_adult=false
    }
}

