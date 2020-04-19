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
public class UsuarioTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tp_usuario", nullable = false, length = 60)
	private String tipoUsuario;
	
	@Column(name = "cd_documento", nullable = false, length = 60)
	private String CpfCnpj;
	
	@Column(name = "nm_usuario", nullable = false, length = 60)
	private String nome;
	
	@Column(name = "cd_email", nullable = false, length = 60)
	private String email;
	
	@Column(name = "cd_senha", nullable = false)
	private String senha;
	
	@Column(name = "im_imagem", nullable = false, length = 300)
	private String imagemUsuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_endereco", nullable = false)
	private EnderecoTable endereco;
	
	public UsuarioTable(){
	}

	public UsuarioTable(Long id, String tipoUsuario, String cpfCnpj, String nome, String email, String senha,
			String imagemUsuario, EnderecoTable endereco) {
		super();
		this.id = id;
		this.tipoUsuario = tipoUsuario;
		this.CpfCnpj = cpfCnpj;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.imagemUsuario = imagemUsuario;
		this.endereco = endereco;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getCpfCnpj() {
		return CpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		CpfCnpj = cpfCnpj;
	}

	public String getImagemUsuario() {
		return imagemUsuario;
	}

	public void setImagemUsuario(String imagemUsuario) {
		this.imagemUsuario = imagemUsuario;
	}

	public EnderecoTable getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoTable endereco) {
		this.endereco = endereco;
	}
	
}
