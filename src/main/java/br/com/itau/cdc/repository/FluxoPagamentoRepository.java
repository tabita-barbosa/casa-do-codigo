package br.com.itau.cdc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.cdc.model.FluxoPagamento;

@Repository
public interface FluxoPagamentoRepository extends JpaRepository<FluxoPagamento, Long>{

}
