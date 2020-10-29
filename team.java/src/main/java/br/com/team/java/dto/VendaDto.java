package br.com.team.java.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.team.java.model.ItemVenda;
import br.com.team.java.model.Venda;
import br.com.team.java.model.enums.StatusPagamento;
import br.com.team.java.model.enums.StatusVenda;
import lombok.Data;

@Data
public class VendaDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private double valor;
	private List<ItemVendaDto> item;
	private UsuarioDto usuario;
	private Date dataVenda = new Date(System.currentTimeMillis());
	private StatusVenda statusVenda;
	private int totalItens;
	private StatusPagamento pagamento;
	private int parcela;

	private double valorParcela;
	
//	public VendaDto(Venda venda ) {
//		super();
//		this.id = venda.getId();
//		this.valor = venda.getValor();
//		this.usuario = new UsuarioDto(venda.getUsuario());
//		this.dataVenda = venda.getDataVenda();
//		this.statusVenda = venda.getStatusVenda();
//		this.totalItens = venda.getTotalItens();
//		//this.item = new List<ItemVendaDto>(venda.getItem().stream().map(dto -> ItemVendaDto(dto) ).collect(Collectors.toList()));
//	
//		this.pagamento = venda.getPagamento();
//	}
	



	public Venda toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		Venda entity = modelMapper.map(this, Venda.class);
		return entity;
	}

}
