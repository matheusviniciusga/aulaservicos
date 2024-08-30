package com.aos.aula01.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aos.aula01.demo.model.Autor;

public interface AutorRepositorio extends JpaRepository<Autor, Long>{
    
    public Autor deleteByCpf(String cpf);
    public Autor findByCpf(String cpf);
    public List<Autor> findByIdade(Short idade);
}
