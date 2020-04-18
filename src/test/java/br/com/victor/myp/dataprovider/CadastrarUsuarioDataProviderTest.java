package br.com.victor.myp.dataprovider;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.dataprovider.entity.UsuarioTable;
import br.com.victor.myp.dataprovider.repository.UsuarioRepository;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarUsuarioDataProviderTest {
	
	@InjectMocks private UsuarioDataProvider usuariodataprovider;
	
	@Mock private UsuarioRepository usuariorepository;
	
	// As entidades entram com id nulo, e retornam com id após salvo no banco
	UsuarioEntity usuario = new UsuarioEntity(null, "Usuario", "12345678909", "Victor", "victor@myp.com",  "KAskdAHJFA", "path/imagem",null);
	
	// Após serem salvas retornam com um id que foi gerado na base de dados
	UsuarioTable usuarioTable = new UsuarioTable(1L, "Usuario", "12345678909", "Victor", "victor@myp.com",  "KAskdAHJFA", "path/imagem", null);
	
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