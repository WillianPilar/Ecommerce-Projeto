package br.com.team.java.dto;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import br.com.team.java.model.ItemVenda;
import br.com.team.java.model.Produto;
import br.com.team.java.model.Venda;
import lombok.Data;

@Data
public class ItemVendaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Produto produto;
	private Venda venda;
	private int quantidade;

	public ItemVendaDto(ItemVenda itemVenda) {
		this.id = itemVenda.getId();
		this.produto = itemVenda.getProduto();
		this.venda = itemVenda.getVenda();
		this.quantidade = itemVenda.getQuantidade();
	}

	public ItemVenda toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		ItemVenda entity = modelMapper.map(this, ItemVenda.class);
		return entity;
	}
}
