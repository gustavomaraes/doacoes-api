package br.com.gustavo.repository;

import br.com.gustavo.banco.Utensilio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtensilioRepository extends JpaRepository<Utensilio, Long> {

    List<Utensilio> findByNomeLike(String nome);

    Utensilio findByNome(String nome);
}
