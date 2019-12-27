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

@RunWith(MockitoJUnitRunner.class)
public class CidadeEntrypointTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void CidadeEntrypoint_success_post() throws Exception{
		EstadoHttpModel estado = new EstadoHttpModel(1L,"SP","São Paulo");
		mvc.perform( MockMvcRequestBuilders
		      .post("/cidades")
		      .content(asJsonString(new CidadeHttpModel(1L,"São Paulo",estado)))
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
