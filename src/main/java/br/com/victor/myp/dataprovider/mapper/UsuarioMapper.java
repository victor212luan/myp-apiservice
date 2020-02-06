package br.com.victor.myp.dataprovider.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.dataprovider.entity.UsuarioTable;


public class UsuarioMapper {

	public static UsuarioEntity to(UsuarioTable table) {
		return Optional.ofNullable(table).map(e -> new UsuarioEntity(
			e.getId(), e.getNome(), e.getEmail(), e.getSenha(), e.getImagemUsuario(),
			EnderecoMapper.to(e.getEndereco())))
			.orElse(new UsuarioEntity());
	}
	
	public static UsuarioTable from(UsuarioEntity entity) {
		return Optional.ofNullable(entity).map(e -> new UsuarioTable(
			e.getId(), e.getNome(), e.getEmail(), e.getSenha(), e.getImagemUsuario(),
			EnderecoMapper.from(e.getEndereco())))
			.orElse(new UsuarioTable());
	}
}
