package br.com.itau.cdc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.cdc.model.FluxoPagamento;
import br.com.itau.cdc.repository.FluxoPagamentoRepository;

@RestController
@RequestMapping("/pagamento")
public class FluxoPagamentoController {
	
	@Autowired
	private FluxoPagamentoRepository fluxoPagamentoRepository;
	
	@GetMapping
	public ResponseEntity<List<FluxoPagamento>> GetAll(){
		return ResponseEntity.ok(fluxoPagamentoRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<FluxoPagamento> cadastrarPagamento(@RequestBody @Valid FluxoPagamento fluxoPagamento){
		return ResponseEntity.status(HttpStatus.OK).body(fluxoPagamentoRepository.save(fluxoPagamento));
	}
}
