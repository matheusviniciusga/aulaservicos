package com.aos.aula01.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aos.aula01.demo.model.Livro;
import com.aos.aula01.demo.repository.LivroRepositorio;

@Service
public class LivroServico {
    
    @Autowired
    private LivroRepositorio livRepo;

    public Livro inserirLivro(Livro l) {
        return livRepo.save(l);
    }

    public void deletarLivro(Livro l) {
        livRepo.delete(l);
    }

    public Livro deletarPeloTitulo(String titulo) {
        return livRepo.deleteByTitulo(titulo);
    }

    public void deletarPelaId(Long id) {
        livRepo.deleteById(id);
    }

    public List<Livro> buscarTodosLivros() {
        return livRepo.findAll();
    }

    public Livro buscarPeloTitulo(String titulo) {
        return livRepo.findByTitulo(titulo);
    }

    public List<Livro> buscarPeloGenero(String genero) {
        return livRepo.findByGenero(genero);
    }
}
