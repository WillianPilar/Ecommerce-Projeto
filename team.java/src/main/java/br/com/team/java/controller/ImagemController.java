package br.com.team.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.team.java.model.Imagem;
import br.com.team.java.repository.ImagemRepository;

@RestController
@RequestMapping("/imagem")
public class ImagemController {
	
	@Autowired
	ImagemRepository imagemRepository;
	
	
	public ResponseEntity<List<Imagem>>getAll(){
		List<Imagem> l = this.imagemRepository.findAll();
		return ResponseEntity.ok().body(l);
	}

}
