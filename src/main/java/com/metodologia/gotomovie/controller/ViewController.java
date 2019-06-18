package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.Movie;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class ViewController {

    @GetMapping("/home")
    public ModelAndView homeView() {
        ModelAndView model = new ModelAndView();
        model.addObject("movie", new Movie());
        model.setViewName("home");
        return model;
    }
}
