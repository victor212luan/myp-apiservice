package br.com.victor.myp.core.entity;

public class UsuarioEntity {
	private Long id;
	private String tipoUsuario;
	private String CpfCnpj;
	private String nome;
	private String email;
	private String senha;
	private String imagemUsuario;
	private EnderecoEntity endereco;
	
	public UsuarioEntity(){
	}

	public UsuarioEntity(Long id, String tipoUsuario, String cpfCnpj, String nome, String email, String senha,
			String imagemUsuario, EnderecoEntity endereco) {
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

	public String getImagemUsuario() {
		return imagemUsuario;
	}

	public void setImagemUsuario(String imagemUsuario) {
		this.imagemUsuario = imagemUsuario;
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public String getCpfCnpj() {
		return CpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		CpfCnpj = cpfCnpj;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
