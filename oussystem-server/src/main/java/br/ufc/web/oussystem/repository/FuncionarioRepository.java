package br.ufc.web.oussystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.web.oussystem.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	@Query("from Funcionario where email = ?1")
	Funcionario findByEmail(String email);

}
