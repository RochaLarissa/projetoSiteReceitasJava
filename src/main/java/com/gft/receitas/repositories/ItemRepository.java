package com.gft.receitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.receitas.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
