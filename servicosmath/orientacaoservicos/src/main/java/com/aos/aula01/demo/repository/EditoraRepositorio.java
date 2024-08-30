package com.aos.aula01.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aos.aula01.demo.model.Editora;

public interface EditoraRepositorio extends JpaRepository<Editora, Long> {
    
    public Editora deleteByCnpj(String cnpj);
    public Editora findByCnpj(String cnpj);
    public List<Editora> findByNome(String nome);
}
