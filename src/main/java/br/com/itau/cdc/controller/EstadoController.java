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

import br.com.itau.cdc.model.Estado;
import br.com.itau.cdc.repository.EstadoRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public ResponseEntity<List<Estado>> GetAll(){
		return ResponseEntity.ok(estadoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> GetById(@PathVariable long id){
		return estadoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Estado> cadastrarEstado (@RequestBody @Valid Estado estado){
		Optional<Estado> estadoDuplicado = estadoRepository.findByNome(estado.getNome());
		if(estadoDuplicado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(estadoRepository.save(estado));
		}
		throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Estado já cadastrado!");
	}
}
