package br.ufc.web.oussystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.web.oussystem.model.OS;

public interface OSRepository extends JpaRepository<OS, Integer>{

	@Query("from OS where status = ?1")
	List<OS> findByStatus(String status);
	@Query("from OS where modelo like %?1%")
	List<OS> findByModelo(String modelo);
	
}
