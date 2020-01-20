package br.com.victor.myp.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.victor.myp.core.entity.CidadeEntity;
import br.com.victor.myp.core.entity.EnderecoEntity;
import br.com.victor.myp.core.entity.EstadoEntity;
import br.com.victor.myp.core.gateway.EnderecoGateway;
import br.com.victor.myp.dataprovider.CidadeDataProvider;
import br.com.victor.myp.dataprovider.EstadoDataProvider;

@Component
public class CadastrarEnderecoUseCase {

	@Autowired
	private EnderecoGateway enderecoGateway;
	
	@Autowired
	private CidadeDataProvider cidadeDataProvider;
	
	@Autowired
	private EstadoDataProvider estadoDataProvider;
	
	public EnderecoEntity cadastrarEndereco(EnderecoEntity entity) {
		// Separando os objetos para maior legibilidade
		EstadoEntity estado = entity.getCidade().getEstado();
		CidadeEntity cidade = entity.getCidade();
		
		estado = estadoDataProvider.cadastrarEstado(estado);
		
		// Setando o estado que foi persistido
		cidade.setEstado(estado);
		
		cidade = cidadeDataProvider.cadastrarCidade(cidade);
		
		// Setando a cidade que foi persistida
		entity.setCidade(cidade);
		
		return enderecoGateway.cadastrarEndereco(entity);
	}
}
