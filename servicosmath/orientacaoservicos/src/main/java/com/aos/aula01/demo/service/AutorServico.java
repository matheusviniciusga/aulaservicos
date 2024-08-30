package com.aos.aula01.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aos.aula01.demo.model.Autor;
import com.aos.aula01.demo.repository.AutorRepositorio;

@Service
public class AutorServico {
    
    @Autowired
    private AutorRepositorio autorRepo;

    public Autor inserirAutor(Autor a) {
        return autorRepo.save(a);
    }

    public void deletarAutor(Autor a) {
        autorRepo.delete(a);
    }

    public Autor deletarPeloCpf(String cpf) {
        return autorRepo.deleteByCpf(cpf);
    }

    public void excluirPelaId(Long id) {
        autorRepo.deleteById(id);
    }

    public List<Autor> buscarTodosAutores() {
        return autorRepo.findAll();
    }

    public Autor buscarPeloCpf(String cpf) {
        return autorRepo.findByCpf(cpf);
    }

    public List<Autor> buscarPelaIdade(Short idade) {
        return autorRepo.findByIdade(idade);
    }
}
