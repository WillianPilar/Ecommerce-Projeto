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

import br.com.team.java.model.Produto;
import br.com.team.java.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		List<Produto> p = this.produtoService.getAll();
		return ResponseEntity.ok().body(p);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Produto> getOne(@PathVariable int id){
		Produto produto = this.produtoService.getOne(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto produto) {
		Produto p = this.produtoService.save(produto);
		return ResponseEntity.ok().body(p);
	}
	
	@PatchMapping(value="{id}")
	public  ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable int id) {
		Produto p = this.produtoService.update(id, produto);
		return ResponseEntity.ok().body(p);
	}
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable int id) {
		this.produtoService.delete(id);
	}
	
	@GetMapping(value ="paginador")
	public ResponseEntity<Page<Produto>> paginacao(@RequestParam(value ="pagina", defaultValue = "0") int pagina, 
							 @RequestParam(value ="linhas", defaultValue = "5") int linhas) {
		Page<Produto> prod = this.produtoService.paginacao(pagina, linhas);
		return ResponseEntity.ok().body(prod);
	}
}
