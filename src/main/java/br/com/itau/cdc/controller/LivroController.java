package br.com.itau.cdc.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.cdc.model.Livro;
import br.com.itau.cdc.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	

	@GetMapping
	public Page<Livro> listarLivros(@RequestParam(required = false) String titulo,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacaoLivro){
		if (titulo == null) {
			return livroRepository.findAll(paginacaoLivro);
		} else {
			return livroRepository.findByTituloContainingIgnoreCase(titulo, paginacaoLivro);
		}
	}
	
	@GetMapping 
	public ResponseEntity<Livro> GetById(@PathVariable long id){
		return livroRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Livro> cadastrarAutor(@RequestBody @Valid Livro livro){
		Optional<Livro> livroDuplicado = livroRepository.findByTitulo(livro.getTitulo());
		if(livroDuplicado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livro));
		}
		throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Livro já esta cadastrado!");
	}

}
