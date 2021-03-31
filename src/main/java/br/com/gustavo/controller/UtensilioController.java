package br.com.gustavo.controller;

import br.com.gustavo.banco.Utensilio;
import br.com.gustavo.repository.UtensilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utensilio")
public class UtensilioController {

    @Autowired
    UtensilioRepository repository;

    @ResponseBody
    @RequestMapping(value = "/grava", method = RequestMethod.POST)
    public String gravaUtensilio(@RequestBody Utensilio utensilio){
        try{
            repository.save(utensilio);
            return "Sucesso!";
        } catch (Exception e){
            return "Erro na gravação: " + e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String removeUtensilio(@PathVariable("id") Long id){
        try{
            repository.deleteById(id);
            return "Sucesso!";
        } catch (Exception e){
            return "Erro na exclusão: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    @ResponseBody
    public Utensilio buscaUtensilio(@RequestBody String nome){
        return repository.findByNome(nome);
    }

    @RequestMapping(value = "/busca-lista", method = RequestMethod.GET)
    @ResponseBody
    public List<Utensilio> buscaListaUtensilios(@RequestBody String nome){
        return repository.findByNomeLike(nome);
    }

    @RequestMapping(value = "/busca-todos", method = RequestMethod.GET)
    @ResponseBody
    public List<Utensilio> buscaTodos(){
        return repository.findAll();
    }
}
