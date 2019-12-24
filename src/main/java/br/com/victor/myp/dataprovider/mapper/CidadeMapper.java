package br.com.victor.myp.dataprovider.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.CidadeEntity;
import br.com.victor.myp.dataprovider.entity.CidadeTable;

public class CidadeMapper {

	public static CidadeEntity to(CidadeTable table) {
		return Optional.ofNullable(table).map(e -> new CidadeEntity(
			e.getId(), e.getNome(), e.getEstado()))
			.orElse(new CidadeEntity());
	}
	
	public static CidadeTable from(CidadeEntity entity) {
		return Optional.ofNullable(entity).map(e -> new CidadeTable(
			e.getId(), e.getNome(), e.getEstado()))
			.orElse(new CidadeTable());
	}
}
