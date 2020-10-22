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

import br.com.team.java.model.Categoria;
import br.com.team.java.service.CategoriaService;


@RestController
@RequestMapping(value = "categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "")
	public ResponseEntity<List<Categoria>> findAll(){
		return ResponseEntity.ok().body(this.categoriaService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> getOne(@PathVariable int id){
		return ResponseEntity.ok().body(this.categoriaService.getOne(id));
	}
	
	@PostMapping(value = "")
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
		return ResponseEntity.ok().body(this.categoriaService.save(categoria));	
	}
	
	@PatchMapping(value = "")
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable int id){
		return ResponseEntity.ok().body(this.categoriaService.update(id, categoria));
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id) {
		
		this.categoriaService.delete(id);
	}
	
	@GetMapping (value = "/pagination")
	public ResponseEntity<Page<Categoria>> paginacao(
			@RequestParam(value = "pagina", defaultValue = "5") int pagina,
			@RequestParam(value = "linhas", defaultValue = "5") int linhas,
			@RequestParam(value = "busca", defaultValue = "" ) String busca){
		return ResponseEntity.ok().body(this.categoriaService.pagination(pagina, linhas, busca));
	}
	
}
