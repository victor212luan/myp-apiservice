package br.com.victor.myp.entrypoint.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.CidadeEntity;
import br.com.victor.myp.entrypoint.mapper.EstadoMapper;
import br.com.victor.myp.entrypoint.entity.CidadeHttpModel;

public class CidadeMapper {

	public static CidadeEntity to(CidadeHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> new CidadeEntity(
			e.getId(), e.getNome(), EstadoMapper.to(e.getEstado())))
			.orElse(new CidadeEntity());
	}
	
	public static CidadeHttpModel from(CidadeEntity entity) {
		return Optional.ofNullable(entity).map(e -> new CidadeHttpModel(
			e.getId(), e.getNome(), EstadoMapper.from(e.getEstado())))
			.orElse(new CidadeHttpModel());
	}
}
