package br.com.victor.myp.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.victor.myp.core.entity.EnderecoEntity;
import br.com.victor.myp.dataprovider.entity.CidadeTable;
import br.com.victor.myp.dataprovider.entity.EnderecoTable;
import br.com.victor.myp.dataprovider.mapper.CidadeMapper;
import br.com.victor.myp.dataprovider.mapper.EnderecoMapper;
import br.com.victor.myp.dataprovider.repository.EnderecoRepository;

public class EnderecoDataProvider {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public EnderecoEntity cadastrarEndereco(EnderecoEntity entity) {
		try {
			EnderecoTable table = EnderecoMapper.from(entity);	
			CidadeTable cidade = CidadeMapper.from(entity.getCidade());
			
			table.setCidade(cidade);
			
			table = enderecoRepository.save(table);
			entity = EnderecoMapper.to(table);
			
			return entity;
		} catch(Exception ex) {
			throw new RuntimeException("Falha na persistência");
		}

	}
}
