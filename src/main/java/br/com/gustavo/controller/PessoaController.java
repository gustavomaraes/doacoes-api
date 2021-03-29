package br.com.gustavo.controller;

import br.com.gustavo.banco.Pessoa;
import br.com.gustavo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @RequestMapping("/grava")
    public void gravaPessoa(@RequestBody Pessoa pessoa){
        repository.save(pessoa);
    }

    @RequestMapping("/remove")
    public void removePessoa(@RequestBody Pessoa pessoa){
        repository.delete(pessoa);
    }

    @RequestMapping("/busca")
    @ResponseBody
    public Pessoa buscaPessoa(@RequestBody String cpf, @RequestBody String nome){
        return repository.findByCpfOrNome(cpf, nome);
    }

    @RequestMapping("/busca-lista")
    @ResponseBody
    public List<Pessoa> buscaListaPessoas(@RequestBody String cpf, @RequestBody String nome){
        return repository.findByCpfIsLikeAndNomeIsLike(cpf, nome);
    }

    @RequestMapping("/busca-todos")
    @ResponseBody
    public List<Pessoa> buscaTodos(){
        return repository.findAll();
    }
}
