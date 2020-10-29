package br.com.team.java.dto;

import java.io.Serializable;
import java.util.List;

import br.com.team.java.model.Produto;
import lombok.Data;

@Data
public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String descricao;

	private List<Produto> produto;

}