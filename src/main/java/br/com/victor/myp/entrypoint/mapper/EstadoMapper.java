package br.com.victor.myp.entrypoint.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.EstadoEntity;
import br.com.victor.myp.entrypoint.entity.EnderecoHttpModel;

public class EstadoMapper {

	public static EstadoEntity to(EnderecoHttpModel endereco) {
		return Optional.ofNullable(endereco).map(estado -> new EstadoEntity(
				null, estado.getEstado()))
			.orElse(new EstadoEntity());
	}

}
