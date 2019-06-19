package br.ufc.web.oussystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.oussystem.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
