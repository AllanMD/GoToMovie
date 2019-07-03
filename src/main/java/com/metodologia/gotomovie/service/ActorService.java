package com.metodologia.gotomovie.service;

import com.metodologia.gotomovie.domain.Actor;
import com.metodologia.gotomovie.repository.ActorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ActorService {
    @Autowired
    ActorRepository actorRepository;

    public void addActor(Actor actor) {
        //actorRepository.addActor(actor);
    }

    public void getAll() {
        //return actorRepository.getAll();
    }
}
