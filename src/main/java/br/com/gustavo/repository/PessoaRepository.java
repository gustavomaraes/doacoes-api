package br.com.gustavo.repository;

import br.com.gustavo.banco.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByCpfIsLikeAndNomeIsLike(String cpf, String nome);

    Pessoa findByCpfOrNome(String cpf, String nome);

    Pessoa findByCpf(String cpf);

}
