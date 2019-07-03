package com.metodologia.gotomovie.service;

import com.metodologia.gotomovie.domain.Score;
import com.metodologia.gotomovie.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public void addScore (Score score){
        scoreRepository.addScore(score);
    }

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public List<Score> getScoreByMovie(int movieId){
        return scoreRepository.getScoreByMovie(movieId);
    }

    public Float getAverageScoreByMovie (int movieId){
        return scoreRepository.getAverageScoreByMovie(movieId);
    }


}
