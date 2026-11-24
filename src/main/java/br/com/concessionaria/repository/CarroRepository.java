package br.com.concessionaria.repository;

import br.com.concessionaria.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Acesso aos dados da tabela "carros".
 * O JpaRepository já fornece save, findAll, findById, deleteById, etc.
 */
@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
