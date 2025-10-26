package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
   
	@Autowired
	private ProductRepository repository;
	
	//metodo para que todos os usuarios retornem ao banco de dados
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findByid(Long id) {
		Optional<Product> obj =repository.findByid(id);
		return obj.get();
	}
}


