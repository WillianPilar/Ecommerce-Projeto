package br.com.team.java.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import br.com.team.java.dto.ImagemDto;
import br.com.team.java.model.Imagem;
import br.com.team.java.service.ImagemService;

@RestController
@RequestMapping (value="imagem")
public class ImagemController {
	
	
	@Autowired
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
	public ResponseEntity<List<ImagemDto>> getAll(){
		List<Imagem> l = this.imagemService.getAll();
		
		List<ImagemDto> imgDto = l.stream().map((objeto)-> new ImagemDto(objeto)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(imgDto);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Imagem> getOneById(@PathVariable int id){
		Imagem imagem = this.imagemService.getOne();
		return ResponseEntity.ok().body(imagem);
	}
	
	
	@GetMapping(value="thumb")
	public ResponseEntity<Imagem> getOne(){
		Imagem imagem = this.imagemService.getOne();
		return ResponseEntity.ok().body(imagem);
	}
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<Imagem> imagemAtualizar(@PathVariable int id, @RequestBody Imagem imagem){
		return ResponseEntity.ok().body(imagemService.atualizarImagem(imagem, id));
	}
	
	@GetMapping(value ="paginador")
	public ResponseEntity<Page<Imagem>> paginacao(
			@RequestParam (value = "pagina", defaultValue = "0") int pagina,
			@RequestParam ( value = "linhas", defaultValue = "5" ) int linhas,
			@RequestParam ( value = "busca", defaultValue = "" ) String busca
							) {
		Page<Imagem> img = this.imagemService.paginacao(pagina, linhas, busca);
		return ResponseEntity.ok().body(img);
	}
	
	
	
}
