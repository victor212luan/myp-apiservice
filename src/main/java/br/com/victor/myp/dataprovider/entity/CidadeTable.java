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
public class CidadeTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "nm_cidade", length = 25, nullable = false) 
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name= "id_estado", nullable = false) 
	private EstadoTable estado;
	
	public CidadeTable() {
	}

	public CidadeTable(Long id, String nome, EstadoTable estado) {
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

	public EstadoTable getEstado() {
		return estado;
	}

	public void setEstado(EstadoTable estado) {
		this.estado = estado;
	}
}
