package com.aos.aula01.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aos.aula01.demo.model.Editora;
import com.aos.aula01.demo.repository.EditoraRepositorio;

@Service
public class EditoraServico {

    @Autowired
    private EditoraRepositorio ediRepo;
    
    public Editora inserirEditora(Editora e) {
        return ediRepo.save(e);
    }

    public void deletarEditora(Editora e) {
        ediRepo.delete(e);
    }

    public Editora deletarPeloCnpj(String cnpj) {
        return ediRepo.deleteByCnpj(cnpj);
    }

    public void deletarPelaId(Long id) {
        ediRepo.deleteById(id);
    }

    public List<Editora> buscarTodasEditoras() {
        return ediRepo.findAll();
    }

    public Editora buscarPeloCnpj(String cnpj) {
        return ediRepo.findByCnpj(cnpj);
    }

    public List<Editora> buscarPeloNome(String nome) {
        return ediRepo.findByNome(nome);
    }
}
