package br.com.team.java.dto;

import java.util.List;

import br.com.team.java.model.Categoria;
import br.com.team.java.model.Imagem;
import br.com.team.java.model.ItemVenda;
import br.com.team.java.model.Produto;
import lombok.Data;

@Data
public class ProdutoDto {
	private String nome;
	private String descricao;
	private double preco;
	private Categoria categoria;
	private List<Imagem> imagens;
	private List<ItemVenda> item;
	
	public ProdutoDto(Produto produto) {
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.categoria = produto.getCategoria();
		this.imagens = produto.getImagens();
		this.item = produto.getItem();
		
	}
}
