package br.com.team.java.dto;

import org.modelmapper.ModelMapper;

import br.com.team.java.model.Endereco;
import br.com.team.java.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDto {

	private int id;
	private String nome;
	private String email;
	private Endereco endereco;

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.endereco = usuario.getEndereco();
	}

	public Usuario toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		Usuario entity = modelMapper.map(this, Usuario.class);
		return entity;
	}
}
