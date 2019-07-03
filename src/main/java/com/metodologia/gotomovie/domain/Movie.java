package com.metodologia.gotomovie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity // comentado porq causa error al correr el proyecto
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    @Id
    private Integer id;
    private String title;
    private String release_date;
    private String poster_path; // movie poster // se agrega despues de:" https://image.tmdb.org/t/p/w300_and_h450_bestv2 " para ver la imagen
    private String posterUrl = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";
    @ManyToMany
    private List<Genre> genres;
    @ManyToMany
    private List<Actor> cast;

    public List<Actor> getCastLimit5(){
        return cast.subList(0,5); // devuelve los primeros 5 actores de la lista
    }

    public String getRelease_date() {
        // el que parsea
        SimpleDateFormat parseador = new SimpleDateFormat("yyyy-MM-dd");
        // el que formatea
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

        Date date = null;
        try {
            date = parseador.parse(this.release_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formateador.format(date);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}