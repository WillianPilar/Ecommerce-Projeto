package br.com.team.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.team.java.model.Usuario;
import br.com.team.java.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> consultarUsuarios(){
		List<Usuario> list = this.usuarioService.consultarTodosUsuarios();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Usuario> consultarUsuario(@PathVariable int id){
		Usuario usuario = this.usuarioService.consultarUsuarioId(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping 
	public ResponseEntity<Usuario>salvarUsuario(@RequestBody Usuario usuario){
		Usuario user = this.usuarioService.salvarUsuario(usuario);
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable int id) {
		this.usuarioService.delete(id); 
	}
	
	@PatchMapping(value ="{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
		Usuario user = this.usuarioService.atualizarUsuario(id, usuario);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/paginadorLike")
	public ResponseEntity<Page<Usuario>> paginacaoLike(@RequestParam(value = "pagina", defaultValue = "0") int pagina,
			@RequestParam(value = "linhas", defaultValue = "5") int linhas,
			@RequestParam(value = "nome", defaultValue = "") String nome) {
		Page<Usuario> page = this.usuarioService.paginacaoLike(pagina, linhas, nome);
		return ResponseEntity.ok().body(page);
	}
	

}
