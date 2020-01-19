package br.com.victor.myp.entrypoint.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.EstadoEntity;
import br.com.victor.myp.entrypoint.entity.EstadoHttpModel;

public class EstadoMapper {

	public static EstadoEntity to(EstadoHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> new EstadoEntity(
			e.getId(), e.getSigla(), e.getNome()))
			.orElse(new EstadoEntity());
	}
	
	public static EstadoHttpModel from(EstadoEntity entity) {
		return Optional.ofNullable(entity).map(e -> new EstadoHttpModel(
			e.getId(), e.getSigla(), e.getNome()))
			.orElse(new EstadoHttpModel());
	}
}
