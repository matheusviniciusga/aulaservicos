package com.aos.aula01.demo.controller;

import java.util.List;

import com.aos.aula01.demo.model.Autor;
import com.aos.aula01.demo.service.AutorServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/api/v1/autor")
@RestController
public class AutorControle {

    @Autowired
    private AutorServico autServico;

    @PostMapping("/add")
    public Autor inserirAutor(@RequestBody Autor a) {
        return autServico.inserirAutor(a);
    }

    @DeleteMapping("/delete")
    public void excluirAutor(@RequestBody Autor a) {
        autServico.deletarAutor(a);
    }

    @DeleteMapping("/delete/{cpf}")
    public Autor excluirPeloCpf(@PathVariable String cpf) {
        return autServico.deletarPeloCpf(cpf);
    }

    @DeleteMapping("/delete/{id}")
    public void excluirPelaId(@PathVariable Long id) {
        autServico.excluirPelaId(id);
    }

    @GetMapping("/all")
    public List<Autor> getTodosAutores() {
        return autServico.buscarTodosAutores();
    }

    @GetMapping("/cpf/{cpf}")
    public Autor getPeloCpf(@PathVariable String cpf) {
        return autServico.buscarPeloCpf(cpf);
    }

    @GetMapping("/idade/{idade}")
    public List<Autor> getPelaIdade(@PathVariable Short idade) {
        return autServico.buscarPelaIdade(idade);
    }
}
