package com.aos.aula01.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Livro {
    
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String titulo;

    @NonNull
    private String genero;

    @NonNull
    private Integer pag;
}
