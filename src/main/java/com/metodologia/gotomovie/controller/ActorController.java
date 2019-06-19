package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.Actor;
import com.metodologia.gotomovie.repository.ActorRepository;
import com.metodologia.gotomovie.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    ActorRepository actorRepo;

    @Autowired
    ActorService actorService;

    @GetMapping
    public Actor getActor(){
        return new Actor(1,"Federico","ELias");
    }

    @PostMapping
    public Actor addActor(@RequestBody Actor actor){
        return actorRepo.save(actor);
    }

    @PostMapping("/add")
    public void addActor2(@RequestBody Actor actor) {
        actorService.addActor(actor);
    }

    @PostMapping("/delete")
    public void delete(@PathVariable Integer id) {

    }
}
