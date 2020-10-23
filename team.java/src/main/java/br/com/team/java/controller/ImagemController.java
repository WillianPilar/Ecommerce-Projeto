package br.com.team.java.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.team.java.model.Imagem;
import br.com.team.java.service.ImagemService;

@RestController
@RequestMapping (value="imagem")
public class ImagemController {
	
	private ImagemService imagemService;
	
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable("id") int id) {
		this.imagemService.delete(id);
	}
	
	@PostMapping
	public ResponseEntity<Imagem> save(@RequestBody Imagem imagem) {
		Imagem img = this.imagemService.save(imagem);
		return ResponseEntity.ok().body(img);
	}
	
	@GetMapping(value="all")
	public ResponseEntity<List<Imagem>> getAll(){
		List<Imagem> l = this.imagemService.getAll();
		return ResponseEntity.ok().body(l);
	}
	
	@GetMapping(value="tumb")
	public ResponseEntity<Imagem> getOne(){
		Imagem imagem = this.imagemService.getOne();
		return ResponseEntity.ok().body(imagem);
	}
}
