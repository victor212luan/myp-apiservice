package br.com.victor.myp.entrypoint.mapper;

import java.util.Optional;

import br.com.victor.myp.core.entity.CidadeEntity;
import br.com.victor.myp.entrypoint.entity.EnderecoHttpModel;

public class CidadeMapper {

	public static CidadeEntity to(EnderecoHttpModel endereco) {
		return Optional.ofNullable(endereco).map(cidade -> new CidadeEntity(
				null, cidade.getCidade(), EstadoMapper.to(cidade)))
			.orElse(new CidadeEntity());
	}

}
