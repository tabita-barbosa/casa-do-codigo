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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.cdc.model.Autor;
import br.com.itau.cdc.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorControler {
	
	@Autowired
	private AutorRepository autorRepository;
	
	// metodo para chamar autor
	@GetMapping
	public Page<Autor> listarAutor(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		if (nome == null) {
			return autorRepository.findAll(paginacao);
		} else {
			return autorRepository.findByNomeContainingIgnoreCase(nome, paginacao);
		}
	}
	
	// metodo para cadastrar autor
	@PostMapping
	public ResponseEntity<Autor> cadastrarAutor(@RequestBody @Valid Autor autor){
		Optional<Autor> emailDuplicado = autorRepository.findByEmail(autor.getEmail());
		if(emailDuplicado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(autorRepository.save(autor));
		}
		throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Email, e autor, já esta cadastrado!");
	}

}
