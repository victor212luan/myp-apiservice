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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.core.usecase.CadastrarUsuarioUseCase;
import br.com.victor.myp.entrypoint.entity.UsuarioHttpModel;
import br.com.victor.myp.entrypoint.utils.SaveImage;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioEntrypointTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private UsuarioEntrypoint usuarioEntrypoint;
	
	@Mock
	private CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
	
	@Mock
	private SaveImage image;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(usuarioEntrypoint).build();
	}
	
	@Test
	public void cadastrarUsuario_success() throws JsonProcessingException, Exception {
		UsuarioHttpModel httpModel = new UsuarioHttpModel();
		
		UsuarioEntity entity = new UsuarioEntity();
		
		Mockito.when(cadastrarUsuarioUseCase.cadastrarUsuario(Mockito.any(UsuarioEntity.class)))
			.thenReturn(entity);
		
		this.mockMvc.perform(
			MockMvcRequestBuilders
			.post("/usuarios/")
			.contentType(MediaType.APPLICATION_JSON)
			.content( new ObjectMapper().writeValueAsString(httpModel) )
			).andExpect(status().isCreated());
	}
	
	@Test
	public void salvarImagem_success() throws JsonProcessingException, Exception {
		Mockito.when(image.saveFoto(Mockito.any(MultipartFile.class))).thenReturn(Mockito.anyString());
		
		MockMultipartFile file = new MockMultipartFile("file", "teste.png", "image/png", "file".getBytes());
        
		MockHttpServletRequestBuilder builder =
			MockMvcRequestBuilders.multipart("/usuarios/file")
  				.file(file.getName(), file.getBytes())
  				.contentType("multipart/form-data");
		
		this.mockMvc.perform(builder).andExpect(status().isOk())
      		.andDo(MockMvcResultHandlers.print());
	}
	
}
