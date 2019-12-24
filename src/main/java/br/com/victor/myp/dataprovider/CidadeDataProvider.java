package br.com.victor.myp.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.victor.myp.core.entity.CidadeEntity;
import br.com.victor.myp.dataprovider.entity.CidadeTable;
import br.com.victor.myp.dataprovider.mapper.CidadeMapper;
import br.com.victor.myp.dataprovider.repository.CidadeRepository;

public class CidadeDataProvider {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public CidadeEntity cadastrarCidade(CidadeEntity entity) {
		try {
			CidadeTable table = CidadeMapper.from(entity);	
			
			table = cidadeRepository.save(table);
			entity = CidadeMapper.to(table);
			
			return entity;
		} catch(Exception ex) {
			throw new RuntimeException("Falha na persistência");
		}

	}
}
