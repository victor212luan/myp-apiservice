package br.com.victor.myp.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.core.gateway.UsuarioGateway;

@Component
public class CadastrarUsuarioUseCase {

	@Autowired
	private UsuarioGateway usuarioGateway;
	
	public UsuarioEntity cadastrarUsuario(UsuarioEntity entity) {	
		
		return usuarioGateway.cadastrarUsuario(entity);
	}
}
