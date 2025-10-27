package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
   
	@Autowired
	private UserRepository repository;
	
	//metodo para que todos os usuarios retornem ao banco de dados
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findByid(Long id) {
		Optional<User> obj =repository.findByid(id);
		return obj.get();
	}
	public User insert(User obj){
		return repository.save(obj);
	}
}


