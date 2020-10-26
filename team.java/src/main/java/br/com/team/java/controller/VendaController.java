package br.com.team.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.team.java.model.Venda;
import br.com.team.java.service.VendaService;

@RestController
@RequestMapping(value="venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping
	public ResponseEntity<List<Venda>> getAll(){
		List<Venda> l = this.vendaService.findAll();
		return ResponseEntity.ok().body(l);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Venda> getOne(@PathVariable int id){
		Venda v = this.vendaService.getOne(id);
		return ResponseEntity.ok().body(v);
	}
	
	@PostMapping
	public ResponseEntity<Venda> save(@RequestBody Venda venda){
		Venda v = this.vendaService.save(venda);
		return ResponseEntity.ok().body(v);
	}
	
	@PatchMapping(value="{id}")
	public ResponseEntity<Venda> update(@RequestBody Venda venda, @PathVariable int id){
		Venda v = this.vendaService.update(id, venda);
		return ResponseEntity.ok().body(v);
	}
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable int id){
		this.vendaService.delete(id);
		
	}

}
