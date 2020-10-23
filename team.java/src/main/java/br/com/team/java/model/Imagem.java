package br.com.team.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

@Table(name = "team_imagem")
public class Imagem {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "team_imagem_seq_id")
	@SequenceGenerator (name = "team_imagem_seq_id", sequenceName = "team_imagem_seq_id", allocationSize = 1)
	private int id;
	private String url;
	
	@ManyToOne
	@JoinColumn (name ="produto_id")
	private Produto produto;
}
