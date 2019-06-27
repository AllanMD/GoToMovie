package com.metodologia.gotomovie.service;

import com.metodologia.gotomovie.domain.ExtraMovie;
import com.metodologia.gotomovie.repository.ExtraMovieRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ExtraMovieService {
    @Autowired
    ExtraMovieRepository extraMovieRepository;

    public void addExtraMovie(ExtraMovie extraMovie) {
        extraMovieRepository.addExtraMovie(extraMovie);
    }

    public List<ExtraMovie> getAll() {
        return extraMovieRepository.getAll();
    }

    public List<ExtraMovie> getExtraMovieById(Integer movieId) {
        List<ExtraMovie> extraMovies = extraMovieRepository.getMovieExtraById(movieId);
        return (extraMovies.size() > 0) ? extraMovies : null;
    }
}
