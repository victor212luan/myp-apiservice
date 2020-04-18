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
			EstadoTable estado = EstadoMapper.from(entity.getCidade().getEstado());
			CidadeTable cidade = CidadeMapper.from(entity.getCidade());
			EnderecoTable table = EnderecoMapper.from(entity);	
			
			estado = estadoRepository.save(estado);
			cidade.setEstado(estado);
			
			cidade = cidadeRepository.save(cidade);
			table.setCidade(cidade);
			
			table = enderecoRepository.save(table);
			
			entity = EnderecoMapper.to(table);
			
			return entity;
		} catch(Exception ex) {
			throw new RuntimeException("Falha na persistência");
		}

	}
}
