package com.metodologia2.gotomovie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metodologia2.gotomovie.domain.Movie;

import java.io.File;
import java.io.IOException;


public class JsonController {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    public static void readObjectMovie() {
        Movie movie = null;
        try {
            movie = JSON_MAPPER.readValue(new File("C:/Users/usuario/Desktop/film.json"), Movie.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(movie.toString());


    }
}
