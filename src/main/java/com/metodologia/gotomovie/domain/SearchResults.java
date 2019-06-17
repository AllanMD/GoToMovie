package com.metodologia.gotomovie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResults {
    private int total_results;
    private int total_pages;
    private List<Movie> results;

    @Override
    public String toString() {
        return "SearchResults{" +
                "total_results=" + total_results +
                ", total_pages=" + total_pages +
                ", results=" + results +
                '}';
    }
}
