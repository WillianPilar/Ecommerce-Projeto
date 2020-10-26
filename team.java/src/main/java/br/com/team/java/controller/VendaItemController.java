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

import br.com.team.java.model.ItemVenda;
import br.com.team.java.service.ItemVendaService;

@RestController
@RequestMapping(value="venda_item")
public class VendaItemController {
	
	@Autowired
	private ItemVendaService itemVendaService;
	
	@GetMapping
	public ResponseEntity<List<ItemVenda>> getAll(){
		List<ItemVenda> l = this.itemVendaService.findAll();
		return ResponseEntity.ok().body(l);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<ItemVenda> getOne(@PathVariable int id){
		ItemVenda v = this.itemVendaService.getOne(id);
		return ResponseEntity.ok().body(v);
	}
	
	@PostMapping
	public ResponseEntity<ItemVenda> save(@RequestBody ItemVenda itemVenda){
		ItemVenda v = this.itemVendaService.save(itemVenda);
		return ResponseEntity.ok().body(v);
	}
	
	@PatchMapping(value="{id}")
	public ResponseEntity<ItemVenda> update(@RequestBody ItemVenda itemVenda, @PathVariable int id){
		ItemVenda v = this.itemVendaService.update(id, itemVenda);
		return ResponseEntity.ok().body(v);
	}
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable int id){
		this.itemVendaService.delete(id);
		
	}

}
