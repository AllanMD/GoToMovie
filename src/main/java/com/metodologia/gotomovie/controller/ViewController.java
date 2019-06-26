package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.Actor;
import com.metodologia.gotomovie.domain.Movie;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("")
public class ViewController {

    @GetMapping({"/home",  "/", ""})
    public ModelAndView homeView() {
        ModelAndView model = new ModelAndView();
        model.addObject("movie", new Movie());
        model.setViewName("home"); // cambiar a home comun despues //home 2 es para probar y si funciona bien pasa a ser home
        return model;
    }

    @GetMapping("template")
    public ModelAndView templateView() {
        ModelAndView model = new ModelAndView();
        model.setViewName("template");
        return model;
    }

    /*@GetMapping("/getAll")
    public ModelAndView getAll() {
        List<Actor> actors = actorService.getAll();
        ModelAndView model = new ModelAndView();
        model.addObject("actors",actors);
        model.setViewName("actor");
        return model;
    }*/

    @GetMapping("header")
    public ModelAndView getHeader() {
        ModelAndView model = new ModelAndView();
        model.addObject("movie", new Movie());
        model.setViewName("header.html");
        return model;
    }
}
