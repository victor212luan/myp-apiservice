package br.com.victor.myp.dataprovider.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.EnderecoEntity;
import br.com.victor.myp.dataprovider.entity.EnderecoTable;


public class EnderecoMapper {

	public static EnderecoEntity to(EnderecoTable table) {
		return Optional.ofNullable(table).map(e -> new EnderecoEntity(
			e.getId(), e.getLogradouro(), e.getNumero(), e.getComplemento(), e.getCep(),
			e.getBairro(), CidadeMapper.to(e.getCidade())))
			.orElse(new EnderecoEntity());
	}
	
	public static EnderecoTable from(EnderecoEntity entity) {
		return Optional.ofNullable(entity).map(e -> new EnderecoTable(
			e.getId(), e.getLogradouro(), e.getNumero(), e.getComplemento(), e.getCep(),
			e.getBairro(), CidadeMapper.from(e.getCidade())))
			.orElse(new EnderecoTable());
	}
}
