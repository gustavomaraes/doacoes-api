package br.com.gustavo.banco;


import javax.persistence.*;

@Entity
@Table(schema = "doacoes", name = "utensilio")
public class Utensilio {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private Long quantidade;

    @Column(nullable = false)
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
