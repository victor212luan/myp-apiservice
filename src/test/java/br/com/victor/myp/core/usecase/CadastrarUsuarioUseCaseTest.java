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
import br.com.victor.myp.dataprovider.EnderecoDataProvider;
import br.com.victor.myp.dataprovider.UsuarioDataProvider;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarUsuarioUseCaseTest {
	
	@InjectMocks
	private CadastrarUsuarioUseCase useCase;
	
	@Mock
	private UsuarioDataProvider usuarioDataProvider;
	@Mock
	private EnderecoDataProvider enderecoDataProvider;
	
	@Test
	public void cadastrarUsuario_success() throws Exception {
		EstadoEntity estado = new EstadoEntity(null, null);
		CidadeEntity cidade = new CidadeEntity(null,null,estado);
		EnderecoEntity endereco = new EnderecoEntity(null,null,null,null,null,null,cidade);
		UsuarioEntity usuario = new UsuarioEntity(null,null,null,null,null,"senhaParaSerEncriptada",null,endereco);
		
		EnderecoEntity enderecoSalvo = endereco;
		enderecoSalvo.setId(1L);

		UsuarioEntity modelo = usuario;
		modelo.setImagemUsuario("/tmp/profiles/images/teste.png");
		modelo.setSenha("qMtb8ht4iuIgNgMTQPNgQFFgaTxEH8uvvNM");
		modelo.setEndereco(enderecoSalvo);
		
		Mockito.when(enderecoDataProvider.cadastrarEndereco(Mockito.any(EnderecoEntity.class))).thenReturn(enderecoSalvo);
		Mockito.when(usuarioDataProvider.cadastrarUsuario(Mockito.any(UsuarioEntity.class))).thenReturn(modelo);
		
		UsuarioEntity response = useCase.cadastrarUsuario(usuario);
		
		Assert.assertEquals(modelo, response);
	}
	
	@Test(expected = RuntimeException.class)
	public void cadastrarUsuario_exception() {
		UsuarioEntity usuario = new UsuarioEntity(null,null,null,null,null,"senhaParaSerEncriptada",null,null);
				
		Mockito.doThrow(new RuntimeException("Falha na persistência"))
			.when(usuarioDataProvider).cadastrarUsuario(Mockito.any(UsuarioEntity.class));
		
		useCase.cadastrarUsuario(usuario);
	}
}