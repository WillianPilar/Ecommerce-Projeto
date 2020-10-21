package br.com.team.java.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team_usuario")
@Entity
public class Usuario {

	private int id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
}
