package br.com.team.java.dto;

import br.com.team.java.model.Imagem;
import lombok.Data;

@Data
public class ImagemDto {
	
	
	private int id;
	private String url;
	private String nome;

	
	public ImagemDto(Imagem imagem) {
		
		this.id = imagem.getId();
		this.url = imagem.getUrl();
		this.nome = imagem.getNome();
		
	}
	
	
	
}


