package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.Actor;
import com.metodologia.gotomovie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
