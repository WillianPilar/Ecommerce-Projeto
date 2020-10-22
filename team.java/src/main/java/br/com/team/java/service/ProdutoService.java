package br.com.team.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.team.java.model.Produto;
import br.com.team.java.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getAll(){
		return this.produtoRepository.findAll();
	}
	
	public Produto getOne(int id) {
		return this.produtoRepository.findById(id).orElse(new Produto());
	}
	
	public Produto save(Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	public Produto update(int id, Produto produto) {
		Optional<Produto> a = this.produtoRepository.findById(id);
		Produto update = null;
		
		if(a.isPresent()) {
			update = a.get();
			
			update.setNome(produto.getNome());
			update.setDescricao(produto.getDescricao());
			update.setPreco(produto.getPreco());
			update = this.produtoRepository.save(update);
		}
		return update;
	}
	
	public void delete(int id){
		this.produtoRepository.deleteById(id);
	}
	
	public List<Produto> findByNomeContainsIgnoreCase(String produto){
		return this.produtoRepository.findByNomeContainsIgnoreCase(produto);
	}
	
	public Page<Produto> paginacao(int pagina, int linhas){
		PageRequest pageRequest = PageRequest.of(pagina, linhas);
		return this.produtoRepository.findAll(pageRequest);
	}
	
	
}
