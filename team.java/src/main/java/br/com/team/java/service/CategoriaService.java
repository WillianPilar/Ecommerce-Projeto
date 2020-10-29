package br.com.team.java.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.team.java.dto.CategoriaDTO;
import br.com.team.java.model.Categoria;
import br.com.team.java.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){
		return this.categoriaRepository.findAll();
	}
	
	public Categoria getOne(int id){
		return this.categoriaRepository.findById(id).orElse(new Categoria());
	}
	
	public Categoria save(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}
	
	public void delete(int id) {
		this.categoriaRepository.deleteById(id);
	}
	
	public Categoria update(int id, Categoria categoria) {
		Optional<Categoria> a = this.categoriaRepository.findById(id);
		Categoria update = null;
		
		if (a.isPresent()) {
			update = a.get();		
		
			update.setNome(categoria.getNome());
			update.setDescricao(categoria.getDescricao());
			
			update = this.categoriaRepository.save(update);
		}
		
		return update;
		
	}
	
	public Page<CategoriaDTO> pagination(int pagina, int linhas, String busca){
		PageRequest pageRequest = PageRequest.of(pagina, linhas);
		Page<Categoria> entities = this.categoriaRepository.findByNomeContainsIgnoreCase(busca, pageRequest);
		Page<CategoriaDTO> dtoPage = entities.map(new Function<Categoria, CategoriaDTO>() {
			@Override
			public CategoriaDTO apply(Categoria entity) {
				CategoriaDTO dto = new CategoriaDTO(entity);
				return dto;
			}
		});
		
		return dtoPage;
	}
	
}
