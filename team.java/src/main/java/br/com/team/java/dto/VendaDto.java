package br.com.team.java.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.team.java.model.Categoria;
import br.com.team.java.model.Venda;
import br.com.team.java.model.enums.StatusPagamento;
import br.com.team.java.model.enums.StatusVenda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendaDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private double valor;
	private List<ItemVendaDTO> item;
	private UsuarioDto usuario;
	private Date dataVenda = new Date(System.currentTimeMillis());
	private StatusVenda statusVenda;
	private int totalItens;
	private StatusPagamento pagamento;
	private int parcela;

	private double valorParcela;
	
	public VendaDto(int id, double valor, UsuarioDto usuario, Date dataVenda, StatusVenda status, int totalItens,
			int totalVendas, List<ItemVendaDTO> itemVenda, StatusPagamento pagamento ) {
		super();
		this.id = id;
		this.valor = valor;
		this.usuario = usuario;
		this.dataVenda = dataVenda;
		this.statusVenda = status;
		this.totalItens = totalItens;
		this.item = itemVenda;
		this.pagamento = pagamento;
	}
	
	public Venda toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		Venda entity = modelMapper.map(this, Venda.class);
		return entity;
	}

}
