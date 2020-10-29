package br.com.team.java.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;

import br.com.team.java.model.Categoria;
import br.com.team.java.model.Endereco;
import br.com.team.java.model.Imagem;
import br.com.team.java.model.ItemVenda;
import br.com.team.java.model.Usuario;
import br.com.team.java.model.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

	private int id;
	private String nome;
	private String email;
	private Endereco endereco;
	private Set<Integer> perfis = new HashSet<>();

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.endereco = usuario.getEndereco();
		this.perfis = usuario.getPerfis();
	}

	public Usuario toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		Usuario entity = modelMapper.map(this, Usuario.class);
		return entity;
	}

//		public Usuario transformaParaObjeto(){
//			//int senha = null;
//		    return new Usuario(id, nome, email, endereco, null, null);
//		}
}
