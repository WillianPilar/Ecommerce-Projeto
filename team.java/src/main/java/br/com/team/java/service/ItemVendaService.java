package br.com.team.java.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.team.java.model.Venda;
import br.com.team.java.repository.VendaRepository;

@Service
public class ItemVendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	public List<Venda> getAll() {
		return this.vendaRepository.findAll();
	}
	
	
}
