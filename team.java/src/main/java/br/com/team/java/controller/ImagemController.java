package br.com.team.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.team.java.model.Imagem;
import br.com.team.java.service.ImagemService;


@RestController
@RequestMapping(value = "imagem")
public class ImagemController {
	
	@Autowired
	private ImagemService imagemService;
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<Imagem> imagemAtualizar(@PathVariable int id, @RequestBody Imagem imagem){
		return ResponseEntity.ok().body(imagemService.atualizarImagem(imagem, id));
	}

	public ResponseEntity<List<Imagem>> getAll(){
		List<Imagem> l = this.imagemService.findAll();
		return ResponseEntity.ok().body(l);
	}
}
