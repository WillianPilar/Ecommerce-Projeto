package br.com.team.java.dto;

import br.com.team.java.model.Endereco;
import br.com.team.java.model.Usuario;
import lombok.Data;

@Data
public class EnderecoDto {
	
	private int id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String estado;
	private String cidade;
	private UsuarioDto usuarioDto;
	
	public EnderecoDto ( Endereco endereco ) {
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
		this.estado = endereco.getEstado();
		this.cidade = endereco.getCidade();
		this.usuarioDto = new UsuarioDto(endereco.getUsuario());

	}
}
