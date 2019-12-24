package br.com.victor.myp.core.entity;

public class EstadoEntity {

	private Long id;
	
	private String sigla;
	private String nome;
	
	public EstadoEntity() {
	}
	
	public EstadoEntity(Long id, String sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}