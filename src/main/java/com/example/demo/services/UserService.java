package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Component
public class UserService {
   
	@Autowired
	private UserRepository repository;
	
	//metodo para que todos os usuarios retornem ao banco de dados
	
	public List<User> findAll(){
		return repository.findAll();
	}
}


