package br.com.victor.myp.core.usecase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.victor.myp.core.entity.CidadeEntity;
import br.com.victor.myp.core.entity.EnderecoEntity;
import br.com.victor.myp.core.entity.EstadoEntity;
import br.com.victor.myp.dataprovider.CidadeDataProvider;
import br.com.victor.myp.dataprovider.EnderecoDataProvider;
import br.com.victor.myp.dataprovider.EstadoDataProvider;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarEnderecoUseCaseTest {
	
	@InjectMocks
	private CadastrarEnderecoUseCase useCase;
	
	@Mock
	private EstadoDataProvider estadoDataProvider;
	
	@Mock
	private CidadeDataProvider cidadeDataProvider;
	
	@Mock
	private EnderecoDataProvider enderecoDataProvider;
	
	@Test
	public void cadastrarEndereco_success() throws Exception {
		EstadoEntity estado = new EstadoEntity();
		CidadeEntity cidade = new CidadeEntity(null,null,estado);
		EnderecoEntity endereco = new EnderecoEntity(null,null,null,null,null,null,cidade);
		
		EnderecoEntity modelo = endereco;
		
		Mockito.when(estadoDataProvider.cadastrarEstado(Mockito.any(EstadoEntity.class))).thenReturn(estado);
		Mockito.when(cidadeDataProvider.cadastrarCidade(Mockito.any(CidadeEntity.class))).thenReturn(cidade);
		Mockito.when(enderecoDataProvider.cadastrarEndereco(Mockito.any(EnderecoEntity.class))).thenReturn(endereco);
		
		EnderecoEntity response = useCase.cadastrarEndereco(endereco);
		
		Assert.assertEquals(modelo, response);
	}
	
	@Test(expected = RuntimeException.class)
	public void cadastrarEndereco_exception() {
		EstadoEntity estado = new EstadoEntity();
		CidadeEntity cidade = new CidadeEntity(null,null,estado);
		EnderecoEntity endereco = new EnderecoEntity(null,null,null,null,null,null,cidade);
		
		Mockito.doThrow(new RuntimeException("Falha na persistência"))
			.when(enderecoDataProvider).cadastrarEndereco(Mockito.any(EnderecoEntity.class));
		
		useCase.cadastrarEndereco(endereco);
	}
}