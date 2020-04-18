package br.com.victor.myp.entrypoint.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.entrypoint.entity.UsuarioHttpModel;


public class UsuarioMapper {

	public static UsuarioEntity to(UsuarioHttpModel httpmodel) {
		return Optional.ofNullable(httpmodel).map(e -> new UsuarioEntity(
			e.getId(), e.getTipoUsuario(), e.getDocumento(), e.getNome(), e.getEmail(), e.getSenha(), e.getImagemUsuario(),
			EnderecoMapper.to(e.getEndereco())))
			.orElse(new UsuarioEntity());
	}
	
	public static UsuarioHttpModel from(UsuarioEntity entity) {
		return Optional.ofNullable(entity).map(e -> new UsuarioHttpModel(
			e.getId(), e.getTipoUsuario(), e.getCpfCnpj(), e.getNome(), e.getEmail(), e.getSenha(), e.getImagemUsuario(),
			EnderecoMapper.from(e.getEndereco())))
			.orElse(new UsuarioHttpModel());
	}
}
