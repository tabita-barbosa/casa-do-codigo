package br.com.itau.cdc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.cdc.model.Pais;
import br.com.itau.cdc.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping
	public ResponseEntity<List<Pais>> GetAll(){
		return ResponseEntity.ok(paisRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pais> GetById(@PathVariable long id){
		return paisRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Pais> cadastrarEstado (@RequestBody @Valid Pais pais){
		Optional<Pais> paisDuplicado = paisRepository.findByNome(pais.getNome());
		if(paisDuplicado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(paisRepository.save(pais));
		}
		throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "País já cadastrado!");
	}
	
}
