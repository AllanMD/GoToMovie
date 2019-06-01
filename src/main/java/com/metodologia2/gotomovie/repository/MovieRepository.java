package com.metodologia2.gotomovie.repository;

import com.metodologia2.gotomovie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
