package br.com.itau.cdc.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.itau.cdc.model.FluxoPagamento;
import br.com.itau.cdc.validation.PessoaFisica;
import br.com.itau.cdc.validation.PessoaJuridica;

public class FluxoPagamentoSequenceProvider implements DefaultGroupSequenceProvider<FluxoPagamento>{
	
	public List<Class<?>> getValidationGroups(FluxoPagamento entity){
		List<Class<?>> groups = new ArrayList<>();
		
		groups.add(FluxoPagamento.class);
		
		if(entity != null) {
			if("PF".equalsIgnoreCase(entity.getTipo())) {
				groups.add(PessoaFisica.class);
			} else if ("PJ".equalsIgnoreCase(entity.getTipo())) {
				groups.add(PessoaJuridica.class);
			}
		}
		
		return groups;
	}

}
