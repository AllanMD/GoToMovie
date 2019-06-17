package com.metodologia.gotomovie.service;

import com.metodologia.gotomovie.domain.Actor;
import com.metodologia.gotomovie.repository.ActorRepository2;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ActorService {
    @Autowired
    ActorRepository2 actorRepository2;

    public void addActor(Actor actor) {
        actorRepository2.addActor(actor);
    }

    public List<Actor> getAll() {
        return actorRepository2.getAll();
    }
}
