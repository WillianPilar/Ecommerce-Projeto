package br.com.team.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.team.java.model.Imagem;
import br.com.team.java.repository.ImagemRepository;

@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository imagemRepository;
		
	public List<Imagem> findAll(){
		return this.imagemRepository.findAll();
	}
	
}
