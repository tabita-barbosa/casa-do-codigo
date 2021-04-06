package br.com.itau.cdc.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.cdc.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	public Optional<Autor> findByEmail(String email);
	
	public Page<Autor> findByNomeContainingIgnoreCase(String nome, Pageable paginacao);
	
	Optional<Autor> findByNome(String nome);

}
