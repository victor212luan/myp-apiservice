package br.com.victor.myp.entrypoint.entity;

public class CidadeHttpModel {
private Long id;
	
	private String nome;
	private EstadoHttpModel estado;
	
	public CidadeHttpModel() {
	}

	public CidadeHttpModel(Long id, String nome, EstadoHttpModel estado) {
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

	public EstadoHttpModel getEstado() {
		return estado;
	}

	public void setEstado(EstadoHttpModel estado) {
		this.estado = estado;
	}
}
