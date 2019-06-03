package com.metodologia2.gotomovie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // comentado porq causa error al correr el proyecto
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Actor {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String lastName;

}
