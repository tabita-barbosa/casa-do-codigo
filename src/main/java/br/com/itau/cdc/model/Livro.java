package br.com.itau.cdc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotBlank
	@Column(unique = true)
	private String isbn;
	
	@NotNull
	@Min(100)
	private Integer numPag;
	
	@NotNull
	@DecimalMin(value = "20")
	private BigDecimal preco;
	
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPubli;
	
	@ManyToOne
	@JsonIgnoreProperties("livro")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("livro")
	private Autor autor;
	
	public Livro () {}
	
	public Livro(Long id, @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotBlank String isbn, @NotNull @Min(100) Integer numPag, @NotNull @DecimalMin("20") BigDecimal preco,
			@NotNull @Future LocalDate dataPubli, Categoria categoria, Autor autor) {
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.isbn = isbn;
		this.numPag = numPag;
		this.preco = preco;
		this.dataPubli = dataPubli;
		this.categoria = categoria;
		this.autor = autor;
	}


	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getNumPag() {
		return numPag;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public LocalDate getDataPubli() {
		return dataPubli;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
	
	
	
	

}
