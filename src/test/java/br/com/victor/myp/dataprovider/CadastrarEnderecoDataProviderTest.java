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
	
	@InjectMocks private EnderecoDataProvider enderecodataprovider;
	
	@Mock private EstadoRepository estadorepository;
	@Mock private CidadeRepository cidaderepository;
	@Mock private EnderecoRepository enderecorepository;
	
	EstadoEntity estado = new EstadoEntity(null,"São Paulo");
	CidadeEntity cidade = new CidadeEntity(null,"Praia Grande",estado);
	EnderecoEntity endereco = new EnderecoEntity(null,"Rua Espírito Santo",391,"apt 122","1170190","Canto do Forte",cidade);
	
	EstadoTable estadoTable = new EstadoTable(1L, "São Paulo");
	CidadeTable cidadeTable = new CidadeTable(1L,"Praia Grande",estadoTable);
	EnderecoTable enderecoTable = new EnderecoTable(1L,"Rua Espírito Santo",391,"apt 122","1170190","Canto do Forte",cidadeTable);
	
	@Test
	public void CadastrarEnderecoDataProvider_success() {

		Mockito.when(estadorepository.save(Mockito.any(EstadoTable.class))).thenReturn(estadoTable);
		Mockito.when(cidaderepository.save(Mockito.any(CidadeTable.class))).thenReturn(cidadeTable);
		Mockito.when(enderecorepository.save(Mockito.any(EnderecoTable.class))).thenReturn(enderecoTable);

		EnderecoEntity result = enderecodataprovider.cadastrarEndereco(endereco);
		
		Assert.assertThat(result.getId(), Matchers.notNullValue());
	}
	
	@Test(expected = RuntimeException.class)
	public void CadastrarEnderecoDataProvider_exception() {
		Mockito.doThrow(new RuntimeException("Teste")).when(enderecorepository).save(Mockito.any(EnderecoTable.class));
		
		enderecodataprovider.cadastrarEndereco(endereco);
	}
}