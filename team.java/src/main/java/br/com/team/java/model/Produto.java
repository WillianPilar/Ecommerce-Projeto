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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "produto_sequence")
	@SequenceGenerator (name = "produto_sequence", sequenceName = "produto_seq_id", allocationSize = 1)
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	
	@ManyToOne
	@JoinColumn (name ="categoria")
	private Categoria categoria;
	
	//@OneToMany (mappedBy = "produto")
	//private List<Imagem> imagem
	
}
