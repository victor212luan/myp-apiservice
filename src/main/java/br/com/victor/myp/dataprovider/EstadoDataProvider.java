package br.com.victor.myp.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.victor.myp.core.entity.EstadoEntity;
import br.com.victor.myp.dataprovider.entity.EstadoTable;
import br.com.victor.myp.dataprovider.mapper.EstadoMapper;
import br.com.victor.myp.dataprovider.repository.EstadoRepository;

public class EstadoDataProvider {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public EstadoEntity cadastrarEstado(EstadoEntity entity) {
		try {
			EstadoTable table = EstadoMapper.from(entity);	
			
			table = estadoRepository.save(table);
			entity = EstadoMapper.to(table);
			
			return entity;
		} catch(Exception ex) {
			throw new RuntimeException("Falha na persistência");
		}

	}
}
