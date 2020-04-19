package br.com.victor.myp.dataprovider.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.EstadoEntity;
import br.com.victor.myp.dataprovider.entity.EstadoTable;

public class EstadoMapper {

	public static EstadoEntity to(EstadoTable table) {
		return Optional.ofNullable(table).map(e -> new EstadoEntity(
			e.getId(), e.getNome()))
			.orElse(new EstadoEntity());
	}
	
	public static EstadoTable from(EstadoEntity entity) {
		return Optional.ofNullable(entity).map(e -> new EstadoTable(
			e.getId(), e.getNome()))
			.orElse(new EstadoTable());
	}
}
