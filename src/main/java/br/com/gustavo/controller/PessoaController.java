package br.com.gustavo.controller;

import br.com.gustavo.banco.Pessoa;
import br.com.gustavo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @ResponseBody
    @RequestMapping(value = "/grava", method = RequestMethod.POST)
    public String gravaPessoa(@RequestBody Pessoa pessoa){
        /*
        * Verifica se o usuário ja existe ou nao, usando o cpf
        * */
        if (repository.findByCpf(pessoa.getCpf()) != null){
            return "Cpf já cadastrado";
        }
        try{
            repository.save(pessoa);
            return "Sucesso!";
        } catch (Exception e){
            return "Erro na gravação: " + e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String removePessoa(@PathVariable("id") Long id){
        try{
            repository.deleteById(id);
            return "Sucesso!";
        } catch (Exception e){
            return "Erro na exclusão: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    @ResponseBody
    public Pessoa buscaPessoa(@RequestBody String cpf, @RequestBody String nome){
        return repository.findByCpfOrNome(cpf, nome);
    }

    @RequestMapping(value = "/busca-lista", method = RequestMethod.GET)
    @ResponseBody
    public List<Pessoa> buscaListaPessoas(@RequestBody String cpf, @RequestBody String nome){
        return repository.findByCpfIsLikeAndNomeIsLike(cpf, nome);
    }

    @RequestMapping(value = "/busca-todos", method = RequestMethod.GET)
    @ResponseBody
    public List<Pessoa> buscaTodos(){
        return repository.findAll();
    }
}
