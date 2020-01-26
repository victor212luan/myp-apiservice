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
import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.dataprovider.entity.CidadeTable;
import br.com.victor.myp.dataprovider.entity.EnderecoTable;
import br.com.victor.myp.dataprovider.entity.EstadoTable;
import br.com.victor.myp.dataprovider.entity.UsuarioTable;
import br.com.victor.myp.dataprovider.repository.UsuarioRepository;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarUsuarioDataProviderTest {
	
	@InjectMocks private UsuarioDataProvider usuariodataprovider;
	
	@Mock private UsuarioRepository usuariorepository;
	
	EstadoEntity estado = new EstadoEntity(1L,"SP","São Paulo");
	CidadeEntity cidade = new CidadeEntity(1L,"Praia Grande",estado);
	EnderecoEntity endereco = new EnderecoEntity(1L,"Rua Espírito Santo",391,"apt 122","1170190","Canto do Forte",cidade);
	UsuarioEntity usuario = new UsuarioEntity(1L, "Victor", "victor@myp.com",  "KAskdAHJFA", "path/imagem",endereco);
	
	EstadoTable estadoTable = new EstadoTable(1L,"SP","São Paulo");
	CidadeTable cidadeTable = new CidadeTable(1L,"Praia Grande",estadoTable);
	EnderecoTable enderecoTable = new EnderecoTable(1L,"Rua Espírito Santo",391,"apt 122","1170190","Canto do Forte",cidadeTable);
	UsuarioTable usuarioTable = new UsuarioTable(1L, "Victor", "victor@myp.com",  "KAskdAHJFA", "path/imagem", enderecoTable);
	
	@Test
	public void CadastrarUsuarioDataProvider_success() {
		Mockito.when(usuariorepository.save(Mockito.any(UsuarioTable.class))).thenReturn(usuarioTable);
		
		UsuarioEntity result = usuariodataprovider.cadastrarUsuario(usuario);
		
		Assert.assertThat(result, Matchers.any(UsuarioEntity.class));
	}
	
	@Test(expected = RuntimeException.class)
	public void CadastrarUsuarioDataProvider_exception() {
		Mockito.doThrow(new RuntimeException("Teste")).when(usuariorepository).save(Mockito.any(UsuarioTable.class));
		
		usuariodataprovider.cadastrarUsuario(usuario);
	}
}