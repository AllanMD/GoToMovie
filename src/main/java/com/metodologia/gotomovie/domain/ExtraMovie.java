package com.metodologia.gotomovie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraMovie {

    @Id
    @GeneratedValue
    private Integer id;
    private Double puntuacion;
    private String comentario;
    private Integer userId;
    private Integer movieId;
}
