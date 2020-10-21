package br.com.team.java.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "team_usuario")
@Entity
public class Usuario {

	private int id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
}
