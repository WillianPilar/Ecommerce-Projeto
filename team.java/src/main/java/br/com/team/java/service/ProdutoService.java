package br.com.team.java.service;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.team.java.dto.ProdutoDto;
import br.com.team.java.model.Categoria;
import br.com.team.java.model.Imagem;
import br.com.team.java.model.Produto;
import br.com.team.java.repository.CategoriaRepository;
import br.com.team.java.repository.ImagemRepository;
import br.com.team.java.repository.ProdutoRepository;
import br.com.team.java.util.DtoUtil;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ImagemRepository imagemRepository;

	public List<Produto> getAll() {
		return this.produtoRepository.findAll();
	}

	public Produto getOne(int id) {
		return this.produtoRepository.findById(id).orElse(new Produto());
	}

	public Produto save(ProdutoDto produtoDto) {
		Produto produto = DtoUtil.produtoFromDto(produtoDto);
		
		if(produto.getCategoria() != null) {
			br.com.team.java.model.Categoria c = this.categoriaRepository.findById(produto.getCategoria().getId())
					.orElse(this.categoriaRepository.save(produto.getCategoria()));
			produto.setCategoria(c);
		}
		return this.produtoRepository.save(produto);
	}

	public Produto update(int id, ProdutoDto produtoDto) {
		
		Produto produto = DtoUtil.produtoFromDto(produtoDto);
		
		Produto newProduto = this.produtoRepository.findById(id).get();
		List<Imagem> imagens = new ArrayList<Imagem>();

		if (produto != null) {
						
			for (Imagem imagem : produto.getImagens()) {
				imagem = imagemRepository.findById(imagem.getId()).get();
				imagens.add(imagem);
			}

			newProduto.setNome(produto.getNome());
			newProduto.setDescricao(produto.getDescricao());
			newProduto.setPreco(produto.getPreco());
			newProduto.setCategoria(produto.getCategoria());
			newProduto.setImagens(imagens);
			
			this.produtoRepository.save(newProduto);
		}
		return newProduto;
	}

	public void delete(int id) {
		this.produtoRepository.deleteById(id);
	}

//	public List<Produto> findByNomeContainsIgnoreCase(String produto) {
//		return this.produtoRepository.findByNomeContainsIgnoreCase(produto);
//	}

	public Page<Produto> paginacao(int pagina, int linhas, String busca) {
		PageRequest pageRequest = PageRequest.of(pagina, linhas);
		return this.produtoRepository.findByNomeContainsIgnoreCase(busca, pageRequest);
	}

}
