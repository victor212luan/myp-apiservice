package br.com.victor.myp.core.entity;

public class CidadeEntity {
	
	private Long id;
	
	private String nome;
	private EstadoEntity estado;
	
	public CidadeEntity() {
	}

	public CidadeEntity(Long id, String nome, EstadoEntity estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
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

	public EstadoEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoEntity estado) {
		this.estado = estado;
	}
	
}