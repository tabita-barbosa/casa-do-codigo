package br.com.itau.cdc.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.cdc.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public Page<Categoria> findByNomeContainingIgnoreCase(String nome, Pageable pagincaoCat);
	
	public Optional<Categoria> findByNome(String nome);

}