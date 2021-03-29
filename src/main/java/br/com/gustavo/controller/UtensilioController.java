package br.com.gustavo.controller;

import br.com.gustavo.banco.Utensilio;
import br.com.gustavo.repository.UtensilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/utensilio")
public class UtensilioController {

    @Autowired
    UtensilioRepository repository;

    @RequestMapping("/grava")
    public void gravaUtensilio(Utensilio utensilio){
        repository.save(utensilio);
    }

    @RequestMapping("/remove")
    public void removeUtensilio(Utensilio utensilio){
        repository.delete(utensilio);
    }

    @RequestMapping("/busca")
    @ResponseBody
    public Utensilio buscaUtensilio(@RequestBody String nome){
        return repository.findByNome(nome);
    }

    @RequestMapping("/busca-lista")
    @ResponseBody
    public List<Utensilio> buscaListaUtensilios(@RequestBody String nome){
        return repository.findByNomeLike(nome);
    }

    @RequestMapping("/busca-todos")
    @ResponseBody
    public List<Utensilio> buscaTodos(){
        return repository.findAll();
    }
}
