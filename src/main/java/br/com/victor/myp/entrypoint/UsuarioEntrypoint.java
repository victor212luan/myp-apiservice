package br.com.victor.myp.entrypoint;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.victor.myp.core.entity.UsuarioEntity;
import br.com.victor.myp.core.usecase.CadastrarUsuarioUseCase;
import br.com.victor.myp.entrypoint.entity.UsuarioHttpModel;
import br.com.victor.myp.entrypoint.mapper.UsuarioMapper;
import br.com.victor.myp.entrypoint.utils.SaveImage;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioEntrypoint {
	
	@Autowired
	private CadastrarUsuarioUseCase usuarioUseCase;
	
	@Autowired
	private SaveImage image;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<UsuarioHttpModel> cadastrarUsuario(@RequestBody UsuarioHttpModel httpModel){
		UsuarioEntity entity = UsuarioMapper.to(httpModel);
		entity = usuarioUseCase.cadastrarUsuario(entity);
		UsuarioHttpModel response = UsuarioMapper.from(entity);
		
		URI uri = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(response.getId())
			.toUri();
		
		return ResponseEntity.created(uri).body(response);
	}
	
	@RequestMapping(value = "/file", consumes = {"multipart/form-data"})
	public ResponseEntity<String> salvarImagem(@RequestPart MultipartFile file){
		image.saveFoto(file);
		String savedPath = image.getRoot() + "/" + image.getDirectoryFotos() + "/" + file.getOriginalFilename();
		
		return ResponseEntity.ok().body(savedPath);
	}
}
