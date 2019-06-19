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

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
