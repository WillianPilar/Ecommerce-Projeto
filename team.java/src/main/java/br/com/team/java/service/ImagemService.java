package br.com.team.java.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.team.java.model.Imagem;
import br.com.team.java.repository.ImagemRepository;

@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository imagemRepository;
	
	public Imagem atualizarImagem(Imagem imagem, int id) {
		Optional<Imagem> imagemBuscada = imagemRepository.findById(id);
		Imagem novaImagem = null;
		
		if(imagemBuscada.isPresent()) {
			novaImagem = imagemBuscada.get();
			
			novaImagem.setUrl(imagem.getUrl());
			novaImagem.setProduto(imagem.getProduto());
			
			novaImagem = imagemRepository.save(novaImagem);
		}
		return novaImagem;
	}
}
