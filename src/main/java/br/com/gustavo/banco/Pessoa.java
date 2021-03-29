package br.com.gustavo.banco;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "doacoes", name = "pessoa")
public class Pessoa {

    @Id
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    private String telefone;

    /*
    * Expandir com dados de login, endereco_id e outras informacoes
    * */

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
