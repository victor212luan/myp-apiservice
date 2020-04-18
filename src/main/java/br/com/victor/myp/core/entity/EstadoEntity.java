package br.com.victor.myp.core.entity;

public class EstadoEntity {

	private Long id;
	
	private String nome;
	
	public EstadoEntity() {
	}
	
	public EstadoEntity(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}