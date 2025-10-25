package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
   
	@Autowired
	private CategoryRepository repository;
	
	//metodo para que todos os usuarios retornem ao banco de dados
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findByid(Long id) {
		Optional<Category> obj =repository.findByid(id);
		return obj.get();
	}
}


