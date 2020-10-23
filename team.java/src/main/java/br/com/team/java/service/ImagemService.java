package br.com.team.java.service;

import java.util.List;
import java.util.Optional;

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

	public List<Imagem> getAll() {
		return this.imagemRepository.findAll();
	}
	
	public Imagem getOne() {
		List<Imagem> l = this.imagemRepository.findAll();
		Imagem i = null;
		if (l.size()>0) {
			i = l.get(0);
		}
		return i;
	}

	public Imagem atualizarImagem(Imagem imagem, int id) {
		Optional<Imagem> imagemBuscada = imagemRepository.findById(id);
		Imagem novaImagem = null;

		if (imagemBuscada.isPresent()) {
			novaImagem = imagemBuscada.get();

			novaImagem.setUrl(imagem.getUrl());
			novaImagem.setProduto(imagem.getProduto());

			novaImagem = imagemRepository.save(novaImagem);
		}
		return novaImagem;
	}
}
