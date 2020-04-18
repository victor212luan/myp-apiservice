package br.com.victor.myp.entrypoint.entity;

import br.com.victor.myp.entrypoint.entity.EnderecoHttpModel;

public class UsuarioHttpModel {
	private Long id;
	private String nome;
	private String tipoUsuario;
	private String documento;
	private String email;
	private String senha;
	private String imagemUsuario;
	private EnderecoHttpModel endereco;
	
	public UsuarioHttpModel(){
	}

	public UsuarioHttpModel(Long id, String nome, String tipoUsuario, String documento, String email, String senha,
			String imagemUsuario, EnderecoHttpModel endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoUsuario = tipoUsuario;
		this.documento = documento;
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

	public String getImagemUsuario() {
		return imagemUsuario;
	}

	public void setImagemUsuario(String imagemUsuario) {
		this.imagemUsuario = imagemUsuario;
	}

	public EnderecoHttpModel getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoHttpModel endereco) {
		this.endereco = endereco;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}