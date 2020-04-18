package br.com.victor.myp.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.victor.myp.core.entity.EnderecoEntity;
import br.com.victor.myp.core.gateway.EnderecoGateway;
import br.com.victor.myp.dataprovider.entity.CidadeTable;
import br.com.victor.myp.dataprovider.entity.EnderecoTable;
import br.com.victor.myp.dataprovider.entity.EstadoTable;
import br.com.victor.myp.dataprovider.mapper.CidadeMapper;
import br.com.victor.myp.dataprovider.mapper.EnderecoMapper;
import br.com.victor.myp.dataprovider.mapper.EstadoMapper;
import br.com.victor.myp.dataprovider.repository.CidadeRepository;
import br.com.victor.myp.dataprovider.repository.EnderecoRepository;
import br.com.victor.myp.dataprovider.repository.EstadoRepository;

@Component
public class EnderecoDataProvider implements EnderecoGateway {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public EnderecoEntity cadastrarEndereco(EnderecoEntity entity) {
		try {
			EnderecoTable table = EnderecoMapper.from(entity);	
			CidadeTable cidade = CidadeMapper.from(entity.getCidade());
			EstadoTable estado = EstadoMapper.from(entity.getCidade().getEstado());
			
			estado = estadoRepository.save(estado);
			cidade = cidadeRepository.save(cidade);
			table = enderecoRepository.save(table);
			
			entity = EnderecoMapper.to(table);
			
			return entity;
		} catch(Exception ex) {
			throw new RuntimeException("Falha na persistência");
		}

	}
}
