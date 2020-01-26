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
import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.dataprovider.UsuarioDataProvider;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarUsuarioUseCaseTest {
	
	@InjectMocks
	private CadastrarUsuarioUseCase useCase;
	
	@Mock
	private UsuarioDataProvider usuarioDataProvider;
	
	@Test
	public void cadastrarUsuario_success() throws Exception {
		EstadoEntity estado = new EstadoEntity(null,null,null);
		CidadeEntity cidade = new CidadeEntity(null,null,estado);
		EnderecoEntity endereco = new EnderecoEntity(null,null,null,null,null,null,cidade);
		UsuarioEntity usuario = new UsuarioEntity(null,null,null,null,null,endereco);
		
		UsuarioEntity modelo = usuario;
		modelo.setImagemUsuario("/tmp/profiles/images/teste.png");
		
		String path = "/tmp/profiles/images/teste.png";
		
		Mockito.when(usuarioDataProvider.cadastrarUsuario(Mockito.any(UsuarioEntity.class))).thenReturn(usuario);
		
		UsuarioEntity response = useCase.cadastrarUsuario(usuario, path);
		
		Assert.assertEquals(modelo, response);
	}
	
	@Test(expected = RuntimeException.class)
	public void cadastrarUsuario_exception() {
		EstadoEntity estado = new EstadoEntity(null,null,null);
		CidadeEntity cidade = new CidadeEntity(null,null,estado);
		EnderecoEntity endereco = new EnderecoEntity(null,null,null,null,null,null,cidade);
		UsuarioEntity usuario = new UsuarioEntity(null,null,null,null,null,endereco);
		
		String path = "/tmp/profiles/images/teste.png";
		
		Mockito.doThrow(new RuntimeException("Falha na persistência"))
			.when(usuarioDataProvider).cadastrarUsuario(Mockito.any(UsuarioEntity.class));
		
		useCase.cadastrarUsuario(usuario, path);
	}
}