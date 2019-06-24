package br.ufc.web.oussystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.web.oussystem.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Query("from Cliente where nome like %?1%")
	List<Cliente> findByNome(String nome);

}
