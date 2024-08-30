package com.aos.aula01.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aos.aula01.demo.model.Livro;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {
    
    public Livro deleteByTitulo(String titulo);
    public Livro findByTitulo(String titulo);
    public List<Livro> findByGenero(String genero);
}
