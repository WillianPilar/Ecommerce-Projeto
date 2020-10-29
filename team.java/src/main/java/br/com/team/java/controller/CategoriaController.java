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

import br.com.team.java.dto.CategoriaDTO;
import br.com.team.java.model.Categoria;
import br.com.team.java.service.CategoriaService;

@RestController
@RequestMapping(value = "categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = this.categoriaService.findAll();
		List<CategoriaDTO> listDTO = list.stream().map((objeto) -> new CategoriaDTO(objeto))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> getOne(@PathVariable int id) {
		Categoria categoria = this.categoriaService.getOne(id);
		CategoriaDTO CategoriaDTO = new CategoriaDTO(categoria);
		return ResponseEntity.ok().body(CategoriaDTO);
	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> save(@RequestBody Categoria categoria) {
		categoria = this.categoriaService.save(categoria);
		CategoriaDTO CategoriaDTO = new CategoriaDTO(categoria);
		return ResponseEntity.ok().body(CategoriaDTO);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@RequestBody Categoria categoria, @PathVariable int id) {
		categoria = this.categoriaService.update(id, categoria);
		CategoriaDTO CategoriaDTO = new CategoriaDTO(categoria);
		return ResponseEntity.ok().body(CategoriaDTO);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id) {
		this.categoriaService.delete(id);
	}

	@GetMapping(value = "/pagination")
	public ResponseEntity<Page<CategoriaDTO>> paginacao(@RequestParam(value = "pagina", defaultValue = "5") int pagina,
			@RequestParam(value = "linhas", defaultValue = "5") int linhas,
			@RequestParam(value = "busca", defaultValue = "") String busca) {
		Page<CategoriaDTO> page = this.categoriaService.pagination(pagina, linhas, busca);
		return ResponseEntity.ok().body(page);
	}

}
