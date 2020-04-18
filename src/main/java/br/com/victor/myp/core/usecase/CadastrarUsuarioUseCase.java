package br.com.victor.myp.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.core.gateway.UsuarioGateway;

@Component
public class CadastrarUsuarioUseCase {

	@Autowired
	private UsuarioGateway usuarioGateway;
	
	private BCryptPasswordEncoder encoderPassword = new BCryptPasswordEncoder();
	
	public UsuarioEntity cadastrarUsuario(UsuarioEntity entity) {
		
		// Criptografando senha do usuário
		String senhaUsuario = entity.getSenha();
		entity.setSenha(encoderPassword.encode(senhaUsuario));
		
		return usuarioGateway.cadastrarUsuario(entity);
	}
}
