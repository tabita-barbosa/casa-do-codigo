package br.com.itau.cdc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.itau.cdc.repository.FluxoPagamentoSequenceProvider;
import br.com.itau.cdc.validation.PessoaFisica;
import br.com.itau.cdc.validation.PessoaJuridica;

@Entity
@Table(name = "pagamento")
@GroupSequenceProvider(value = FluxoPagamentoSequenceProvider.class)
public class FluxoPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Email
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	private String tipo;
	
	@NotBlank
	@CPF (groups = PessoaFisica.class)
	@CNPJ (groups = PessoaJuridica.class)
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String telefone;
	
	@NotBlank 
	@ManyToOne
	private Pais pais;;
	
	@NotBlank
	@ManyToOne
	private Estado estado;
	
	public FluxoPagamento () {}

	public FluxoPagamento(Long id, 
			@NotBlank @Email String nome, 
			@NotBlank String sobrenome,
			@NotBlank String tipo,
			@NotBlank @CPF(groups = PessoaFisica.class) @CNPJ(groups = PessoaJuridica.class) String documento,
			@NotBlank String endereco, 
			@NotBlank String complemento, 
			@NotBlank String cidade, 
			@NotBlank String cep,
			@NotBlank String telefone, 
			@NotBlank Pais pais, 
			@NotBlank Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipo = tipo;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.telefone = telefone;
		this.pais = pais;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}
	
	
}
