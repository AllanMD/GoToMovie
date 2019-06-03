package com.metodologia2.gotomovie.Service;

import com.metodologia2.gotomovie.domain.Movie;
import com.metodologia2.gotomovie.domain.SearchResults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@RestController
//@RequestMapping("/actor")
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
