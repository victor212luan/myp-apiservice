package br.com.victor.myp.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.victor.myp.core.entity.EnderecoEntity;
import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.core.gateway.EnderecoGateway;
import br.com.victor.myp.core.gateway.UsuarioGateway;

@Component
public class CadastrarUsuarioUseCase {

	@Autowired
	private UsuarioGateway usuarioGateway;
	
	@Autowired
	private EnderecoGateway enderecoGateway;
	
	private BCryptPasswordEncoder encoderPassword = new BCryptPasswordEncoder();
	
	public UsuarioEntity cadastrarUsuario(UsuarioEntity entity) {
		
		EnderecoEntity enderecoSalvo = enderecoGateway.cadastrarEndereco(entity.getEndereco());
		
		// Criptografando senha do usuário
		String senhaUsuario = entity.getSenha();
		entity.setSenha(encoderPassword.encode(senhaUsuario));
		
		entity.setEndereco(enderecoSalvo);
		return usuarioGateway.cadastrarUsuario(entity);
	}
}
