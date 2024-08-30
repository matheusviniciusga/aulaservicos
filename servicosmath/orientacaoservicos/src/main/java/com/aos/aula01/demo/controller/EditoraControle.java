package com.aos.aula01.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aos.aula01.demo.model.Editora;
import com.aos.aula01.demo.service.EditoraServico;


@RequestMapping("/api/v1/editora")
@RestController
public class EditoraControle {
    
    @Autowired
    public EditoraServico ediServico;

    @PostMapping("/add")
    public Editora inserirEditora(@RequestBody Editora e) {
        return ediServico.inserirEditora(e);
    }

    @DeleteMapping("/delete")
    public void excluirEditora(@RequestBody Editora e) {
        ediServico.deletarEditora(e);
    }

    @DeleteMapping("/delete/{cnpj}")
    public Editora excluirPeloCnpj(@PathVariable String cnpj) {
        return ediServico.deletarPeloCnpj(cnpj);
    }

    @DeleteMapping("/delete/{idf}")
    public void excluirPelaId(@PathVariable Long id) {
        ediServico.deletarPelaId(id);
    }

    @GetMapping("/all")
    public List<Editora> getTodasEditoras() {
        return ediServico.buscarTodasEditoras();
    }

    @GetMapping("/cnpj/{cnpj}")
    public Editora getPeloCnpj(@PathVariable String cnpj) {
        return ediServico.buscarPeloCnpj(cnpj);
    }

    @GetMapping("/nome/{nome}")
    public List<Editora> getPeloNome(@PathVariable String nome) {
        return ediServico.buscarPeloNome(nome);
    }
}
