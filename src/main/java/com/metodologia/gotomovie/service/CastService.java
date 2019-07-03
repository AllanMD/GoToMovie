package com.metodologia.gotomovie.service;

import com.metodologia.gotomovie.domain.Cast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CastService {

    public Cast getCastByMovieId (int id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+id+"/credits?api_key=8d7db92be0746d3da167842d227f2f64", Cast.class);
    }
}
