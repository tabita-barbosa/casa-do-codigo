package br.com.itau.cdc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique=true)
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	@JsonIgnoreProperties("categoria")
	private List<Livro> livro;
	
	public Categoria() {}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Livro> getLivro() {
		return livro;
	}
	

}
