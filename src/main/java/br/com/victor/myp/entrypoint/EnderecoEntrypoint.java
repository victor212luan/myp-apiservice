package br.com.victor.myp.entrypoint;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.victor.myp.core.entity.EnderecoEntity;
import br.com.victor.myp.core.usecase.CadastrarEnderecoUseCase;
import br.com.victor.myp.entrypoint.entity.EnderecoHttpModel;
import br.com.victor.myp.entrypoint.mapper.EnderecoMapper;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoEntrypoint {
	
	@Autowired
	private CadastrarEnderecoUseCase useCase;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<EnderecoHttpModel> cadastrarEndereco(@RequestBody EnderecoHttpModel httpModel){
		EnderecoEntity entity = EnderecoMapper.to(httpModel);
		entity = useCase.cadastrarEndereco(entity);
		EnderecoHttpModel response = EnderecoMapper.from(entity);
		
		URI uri = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(response.getId())
			.toUri();
		
		return ResponseEntity.created(uri).body(response);
	}
}
