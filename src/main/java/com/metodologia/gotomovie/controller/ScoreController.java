package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.Score;
import com.metodologia.gotomovie.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;
    @Autowired
    ViewController viewController;

    @PostMapping("/add")
    public ModelAndView addScore(@RequestParam int movieId, @RequestParam int score){

        Score s = new Score();
        s.setMovieId(movieId);
        s.setScore(score);
        scoreService.addScore(s);

        ModelAndView modelAndView = viewController.searchById(movieId);
        return modelAndView;

    }

    public List<Score> getAll(){
        return scoreService.getAll();
    }

    public String getAverageScoreByMovie (int movieId){
        float averageScore = scoreService.getAverageScoreByMovie(movieId);
        return String.format("%.1f", averageScore); // para limitar los decimales del float
    }

}
