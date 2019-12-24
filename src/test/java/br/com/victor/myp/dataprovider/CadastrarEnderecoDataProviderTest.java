package br.com.victor.myp.dataprovider;

import org.hamcrest.Matchers;
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
import br.com.victor.myp.dataprovider.entity.CidadeTable;
import br.com.victor.myp.dataprovider.entity.EnderecoTable;
import br.com.victor.myp.dataprovider.entity.EstadoTable;
import br.com.victor.myp.dataprovider.repository.CidadeRepository;
import br.com.victor.myp.dataprovider.repository.EnderecoRepository;
import br.com.victor.myp.dataprovider.repository.EstadoRepository;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarEnderecoDataProviderTest {

	// TODO Desenvolver testes de falha no DataProvider
	
	@InjectMocks private EstadoDataProvider estadodataprovider;
	@InjectMocks private CidadeDataProvider cidadedataprovider;
	@InjectMocks private EnderecoDataProvider enderecodataprovider;
	
	@Mock private EstadoRepository estadorepository;
	@Mock private CidadeRepository cidaderepository;
	@Mock private EnderecoRepository enderecorepository;
	
	EstadoEntity estado = new EstadoEntity(1L,"SP","São Paulo");
	CidadeEntity cidade = new CidadeEntity(1L,"Praia Grande",estado);
	EnderecoEntity endereco = new EnderecoEntity(1L,"Rua Espírito Santo",391,"apt 122","1170190","Canto do Forte",cidade);
	
	EstadoTable estadoTable = new EstadoTable(1L,"SP","São Paulo");
	CidadeTable cidadeTable = new CidadeTable(1L,"Praia Grande",estado);
	EnderecoTable enderecoTable = new EnderecoTable(1L,"Rua Espírito Santo",391,"apt 122","1170190","Canto do Forte",cidade);
	
	@Test
	public void CadastrarEstadoDataProvider_success() {
		Mockito.when(estadorepository.save(Mockito.any(EstadoTable.class))).thenReturn(estadoTable);
		
		EstadoEntity result = estadodataprovider.cadastrarEstado(estado);
		
		Assert.assertThat(result, Matchers.any(EstadoEntity.class));
	}
	
	@Test
	public void CadastrarCidadeDataProvider_success() {
		Mockito.when(cidaderepository.save(Mockito.any(CidadeTable.class))).thenReturn(cidadeTable);
		
		CidadeEntity result = cidadedataprovider.cadastrarCidade(cidade);
		
		Assert.assertThat(result, Matchers.any(CidadeEntity.class));
	}
	
	@Test
	public void CadastrarEnderecoDataProvider_success() {
		Mockito.when(enderecorepository.save(Mockito.any(EnderecoTable.class))).thenReturn(enderecoTable);
		
		EnderecoEntity result = enderecodataprovider.cadastrarEndereco(endereco);
		
		Assert.assertThat(result, Matchers.any(EnderecoEntity.class));
	}
}