package com.gft.receitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.receitas.entities.Item;
import com.gft.receitas.repositories.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	public Item salvarItem(Item item) {
		
		return itemRepository.save(item);
	}
	
	
	public List<Item> listarItem() {
		
		return itemRepository.findAll();
	}
	
	
	public Item obterItem(Long id) throws Exception{
		
		Optional<Item> item = itemRepository.findById(id);
		
		if(item.isEmpty()) {
			throw new Exception("Item não encontrado");
		}
		
		return item.get();
	}
	
	
	public void excluirItem(Long id) {
		
		itemRepository.deleteById(id);
	}

}
