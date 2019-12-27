package br.com.victor.myp.entrypoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.victor.myp.core.entity.CidadeEntity;
import br.com.victor.myp.core.entity.EstadoEntity;

@RunWith(MockitoJUnitRunner.class)
public class CidadeEntrypointTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void CidadeEntrypoint_success_post() throws Exception{
		EstadoEntity estado = new EstadoEntity(1L,"SP","São Paulo");
		mvc.perform( MockMvcRequestBuilders
		      .post("/cidades")
		      .content(asJsonString(new CidadeEntity(1L,"Blumenau",estado)))
		      .contentType(MediaType.APPLICATION_JSON)
		      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
