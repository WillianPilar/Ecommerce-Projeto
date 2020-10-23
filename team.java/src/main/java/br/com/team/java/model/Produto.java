package br.com.team.java.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "team_produto")
public class Produto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "team_produto_seq_id")
	@SequenceGenerator (name = "team_produto_seq_id", sequenceName = "team_produto_seq_id", allocationSize = 1)
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	
	@ManyToOne
	@JoinColumn (name ="categoria_id")
	private Categoria categoria;
	
	//@OneToMany (mappedBy = "produto")
	//private List<Imagem> imagem
	
}
