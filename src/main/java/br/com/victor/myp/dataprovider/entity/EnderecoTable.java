package br.com.victor.myp.dataprovider.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EnderecoTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nm_logradouro", nullable = false) 
	private String logradouro;
	
	@Column(name="cd_numero", nullable = false) 
	private Integer numero;
	
	@Column(name="ds_complemento", nullable = true) 
	private String complemento;
	
	@Column(name="cd_cep", nullable = false) 
	private String cep;
	
	@Column(name="nm_bairro", nullable = false) 
	private String bairro;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_cidade", nullable = false)
	private CidadeTable cidade;
	
	public EnderecoTable(){
	}

	public EnderecoTable(Long id, String logradouro, Integer numero, String complemento, String cep, String bairro, CidadeTable cidade) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public CidadeTable getCidade() {
		return cidade;
	}

	public void setCidade(CidadeTable cidade) {
		this.cidade = cidade;
	}
}
