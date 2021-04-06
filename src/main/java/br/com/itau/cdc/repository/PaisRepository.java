package br.com.itau.cdc.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.cdc.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

	Page<Pais> findByNomeContainingIgnoreCase(String nome, Pageable paginacaoPais);
	
	Optional<Pais> findByNome(String nome);

}
