package br.com.team.java.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.team.java.model.Venda;
import br.com.team.java.model.enums.StatusPagamento;
import br.com.team.java.model.enums.StatusVenda;
import lombok.Data;

@Data
public class VendaDto implements Serializable {
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

	public Venda toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		Venda entity = modelMapper.map(this, Venda.class);
		return entity;
	}

}
