package com.aos.aula01.demo.controller;

import java.util.List;

import com.aos.aula01.demo.model.Livro;
import com.aos.aula01.demo.service.LivroServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/api/v1/livro")
@RestController
public class LivroControle {
    
    @Autowired
    private LivroServico livServico;

    @PostMapping("/add")
    public Livro inserirLivro(@RequestBody Livro l) {
        return livServico.inserirLivro(l);
    }

    @DeleteMapping("/delete")
    public void excluirLivro(@RequestBody Livro l) {
        livServico.deletarLivro(l);
    }

    @DeleteMapping("/delete/{titulo}")
    public Livro excluirPeloTitulo(@PathVariable String titulo) {
        return livServico.deletarPeloTitulo(titulo);
    }

    @DeleteMapping("/delete/{id}")
    public void excluirPelaId(@PathVariable Long id) {
        livServico.deletarPelaId(id);
    }

    @GetMapping("/all")
    public List<Livro> getTodosLivros() {
        return livServico.buscarTodosLivros();
    }
    
    @GetMapping("/titulo/{titulo}")
    public Livro getPeloTitulo(@PathVariable String titulo) {
        return livServico.buscarPeloTitulo(titulo);
    }

    @GetMapping("/genero/{genero}")
    public List<Livro> getPeloGenero(@PathVariable String genero) {
        return livServico.buscarPeloGenero(genero);
    }
}
