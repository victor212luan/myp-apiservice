package br.com.victor.myp.entrypoint.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.EnderecoEntity;
import br.com.victor.myp.entrypoint.mapper.CidadeMapper;
import br.com.victor.myp.entrypoint.entity.EnderecoHttpModel;


public class EnderecoMapper {

	public static EnderecoEntity to(EnderecoHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> new EnderecoEntity(
			e.getId(), e.getLogradouro(), e.getNumero(), e.getComplemento(), e.getCep(),
			e.getBairro(), CidadeMapper.to(e.getCidade())))
			.orElse(new EnderecoEntity());
	}
	
	public static EnderecoHttpModel from(EnderecoEntity entity) {
		return Optional.ofNullable(entity).map(e -> new EnderecoHttpModel(
			e.getId(), e.getLogradouro(), e.getNumero(), e.getComplemento(), e.getCep(),
			e.getBairro(), CidadeMapper.from(e.getCidade())))
			.orElse(new EnderecoHttpModel());
	}
}
