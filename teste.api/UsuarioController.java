package br.ifba.teste.api;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.teste.repository.UsuarioRepository;
import br.ifba.teste.model.UsuarioModel;


@RestController
@RequestMapping ("/usuario")
public class UsuarioController {

	private UsuarioRepository usuRepository;

	
	public UsuarioController(UsuarioRepository usuRepository) {
		super();
		this.usuRepository = usuRepository;
	}
	

	@GetMapping
	 public String teste() {
		return "Testando rota usuario";
	
}
	
	@GetMapping ("/listall")
	 public List<UsuarioModel> listall() {
		var usuarios = usuRepository.findAll();
		return usuarios;
	}
	
		@GetMapping("/{id}")
		public UsuarioModel findById (@PathVariable ("id") Long id) {
			Optional<UsuarioModel> usuario = usuRepository.findById(id);
			if (usuario.isPresent ()  )
				return usuario.get();
			return null;
			
		}
	
		@PostMapping("/")
		@ResponseStatus ( HttpStatus.CREATED)
		public boolean insert (@RequestBody UsuarioModel usuarioModel) {
			try {
				usuRepository.save(usuarioModel);
				return true;
			}
			catch (Exception e) {
				return false;
			}
		} 
		
		@DeleteMapping("/{id}")
		@ResponseStatus ( HttpStatus.ACCEPTED)
		public boolean delete (@PathVariable ("id") Long id) {
			System.out.println ("delete");
			try {
				usuRepository.deleteById(id);
				return true;
			}
			
			catch (Exception e) {
				return false;
			}
		}
		
	
}
