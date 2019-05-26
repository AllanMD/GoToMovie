package com.metodologia2.gotomovie.controller;

import com.metodologia2.gotomovie.domain.Actor;
import com.metodologia2.gotomovie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    ActorRepository actorRepo;

    @GetMapping
    public Actor getActor(){
        return new Actor(1,"Federico","ELias");
    }

    @PostMapping
    public Actor addActor(@RequestBody Actor actor){
        return actorRepo.save(actor);
    }
}
