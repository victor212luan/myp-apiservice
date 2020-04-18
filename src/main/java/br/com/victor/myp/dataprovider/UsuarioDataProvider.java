package br.com.victor.myp.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.core.gateway.UsuarioGateway;
import br.com.victor.myp.dataprovider.entity.UsuarioTable;
import br.com.victor.myp.dataprovider.mapper.UsuarioMapper;
import br.com.victor.myp.dataprovider.repository.UsuarioRepository;

@Component
public class UsuarioDataProvider implements UsuarioGateway {

	@Autowired
	private UsuarioRepository enderecoRepository;
	
	public UsuarioEntity cadastrarUsuario(UsuarioEntity entity) {
		try {
			UsuarioTable table = UsuarioMapper.from(entity);
			
			table = enderecoRepository.save(table);
			entity = UsuarioMapper.to(table);
			
			return entity;
		} catch(Exception ex) {
			throw new RuntimeException("Falha na persistência: ", ex);
		}

	}
}
