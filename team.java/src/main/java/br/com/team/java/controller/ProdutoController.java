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

import br.com.team.java.dto.ProdutoDto;
import br.com.team.java.model.Produto;
import br.com.team.java.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> getAll(){
		List<Produto> produto = this.produtoService.getAll();
		
		List<ProdutoDto> produtoDto = produto.stream().map( (objeto) -> new ProdutoDto(objeto) ).collect(Collectors.toList()); 
		
		return ResponseEntity.ok().body(produtoDto);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<ProdutoDto> getOne(@PathVariable int id){
		Produto produto = this.produtoService.getOne(id);
		
		ProdutoDto produtoDto = new ProdutoDto(produto);
		
		return ResponseEntity.ok().body(produtoDto);
	}
	
//	@GetMapping(value="/search")
//	public ResponseEntity<List<Produto>>findByNomeContainsIgnoreCase(@RequestParam String nome){
//		List<Produto> p = this.produtoService.findByNomeContainsIgnoreCase(nome);
//		return ResponseEntity.ok().body(p);
//	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> create(@RequestBody Produto produto) {
		Produto p = this.produtoService.save(produto);
		
		ProdutoDto produtoDto = new ProdutoDto(p);
		
		return ResponseEntity.ok().body(produtoDto);
	}
	
	@PatchMapping(value="{id}")
	public  ResponseEntity<ProdutoDto> update(@RequestBody Produto produto, @PathVariable int id) {
		Produto p = this.produtoService.update(id, produto);
		
		ProdutoDto produtoDto = new ProdutoDto(p);
		return ResponseEntity.ok().body(produtoDto);
	}
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable int id) {
		this.produtoService.delete(id);
	}
	
	@GetMapping(value ="paginador")
	public ResponseEntity<Page<Produto>> paginacao(
			@RequestParam (value = "pagina", defaultValue = "0") int pagina,
			@RequestParam ( value = "linhas", defaultValue = "5" ) int linhas,
			@RequestParam ( value = "busca", defaultValue = "" ) String busca
							) {
		Page<Produto> produto = this.produtoService.paginacao(pagina, linhas, busca);
		
		//Page<ProdutoDto> produtoDto = (Page<ProdutoDto>) produto.stream().map((objeto)-> new ProdutoDto(objeto)).collect(Collectors.toList()); 
		
		return ResponseEntity.ok().body(produto);
	}
}
