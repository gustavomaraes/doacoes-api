package br.com.gustavo.banco;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "doacoes", name = "utensilio")
public class Utensilio {

    @Id
    private Long id;

    @NotNull
    private String nome;

    private String descricao;

    @NotNull
    private Long quantidade;

    @NotNull
    private boolean disponivel;

    /*
     * Expandir com dados de tamanho, peso, foto, etc
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
