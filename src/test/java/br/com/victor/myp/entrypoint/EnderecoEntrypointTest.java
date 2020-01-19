package br.com.victor.myp.entrypoint;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.victor.myp.core.entity.EnderecoEntity;
import br.com.victor.myp.core.usecase.CadastrarEnderecoUseCase;
import br.com.victor.myp.entrypoint.entity.EnderecoHttpModel;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoEntrypointTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private EnderecoEntrypoint enderecoEntrypoint;
	
	@Mock
	private CadastrarEnderecoUseCase cadastrarEnderecoUseCase;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(enderecoEntrypoint).build();
	}
	
	@Test
	public void cadastrarEndereco_success() throws JsonProcessingException, Exception {
		EnderecoHttpModel httpModel = new EnderecoHttpModel();
		
		EnderecoEntity entity = new EnderecoEntity();
		
		Mockito.when(cadastrarEnderecoUseCase.cadastrarEndereco(Mockito.any(EnderecoEntity.class)))
			.thenReturn(entity);
	
		this.mockMvc.perform(
			MockMvcRequestBuilders
			.post("/enderecos/")
			.contentType(MediaType.APPLICATION_JSON)
			.content( new ObjectMapper().writeValueAsString(httpModel) )
			).andExpect(status().isCreated());
	}

}
