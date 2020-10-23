package br.com.team.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.team.java.model.Imagem;
import br.com.team.java.repository.ImagemRepository;




@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository imagemRepository;

	
	public void delete(int id) {
		this.imagemRepository.deleteById(id);
	}
	
	public Imagem save(Imagem imagem) {
		return this.imagemRepository.save(imagem);
	}
}
