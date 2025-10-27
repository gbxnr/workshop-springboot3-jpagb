package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;
import jakarta.el.ELManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public User insert(User obj){
		return repository.save(obj);
	}

	public void delete(Long id){
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}
	public User update(Long id, User obj){
		try {
			User entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e){
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
	entity.setName(obj.getName());
	entity.setEmail(obj.getEmail());
	entity.setPhone(obj.getPhone());
	}
}


