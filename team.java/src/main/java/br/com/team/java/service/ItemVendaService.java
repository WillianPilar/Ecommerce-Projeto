package br.com.team.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.team.java.model.ItemVenda;
import br.com.team.java.repository.ItemVendaRepository;

@Service
public class ItemVendaService {

	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	public List<ItemVenda> findAll() {
		return this.itemVendaRepository.findAll();
	}
	
	public ItemVenda getOne(int id) {
		return this.itemVendaRepository.findById(id).orElse(new ItemVenda());
				//.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public ItemVenda save(ItemVenda itemvenda) {
		return this.itemVendaRepository.save(itemvenda);
	}
	
	public ItemVenda update(int id, ItemVenda venda) {
		Optional<ItemVenda> a = this.itemVendaRepository.findById(id);
		ItemVenda update = null;
		
		if(a.isPresent()) {
			update = a.get();
			
			update.setProduto(venda.getProduto());
			update.setQuantidade(venda.getQuantidade());
			update.setVenda(venda.getVenda());
			
			update = this.itemVendaRepository.save(update);
		}
		return update;
	}
	
	public void delete(int id) {
		this.itemVendaRepository.deleteById(id);
	}
}
