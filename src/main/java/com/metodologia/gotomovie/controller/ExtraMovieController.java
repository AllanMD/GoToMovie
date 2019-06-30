package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.ExtraMovie;
import com.metodologia.gotomovie.service.ExtraMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/extra")
public class ExtraMovieController {

    @Autowired
    ExtraMovieService extraService;

    @GetMapping("")
    public List<ExtraMovie> getAll() {
        return extraService.getAll();
    }

    @PostMapping("/agregar")
    public void addExtraMovie(@RequestBody ExtraMovie extraMovie) {
        extraService.addExtraMovie(extraMovie);
    }

    @GetMapping("/getByMovieID/{id}")
    public List<ExtraMovie> getByMovieId(@PathVariable Integer id) {
        return extraService.getExtraMovieById(id);
    }
}
