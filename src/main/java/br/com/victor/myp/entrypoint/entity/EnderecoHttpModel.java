package br.com.victor.myp.entrypoint.entity;

public class EnderecoHttpModel {

	private Long id;
	
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cep;
	private String bairro;
	
	private CidadeHttpModel cidade;
	
	public EnderecoHttpModel(){
	}

	public EnderecoHttpModel(Long id, String logradouro, Integer numero, String complemento, String cep, String bairro, CidadeHttpModel cidade) {
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

	public CidadeHttpModel getCidade() {
		return cidade;
	}

	public void setCidade(CidadeHttpModel cidade) {
		this.cidade = cidade;
	}
	
}