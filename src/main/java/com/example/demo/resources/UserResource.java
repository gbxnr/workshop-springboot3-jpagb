package com.example.demo.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
    @GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
    
    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findBayId(@PathVariable Long id){
    	User obj = service.findByid(id);
    	return ResponseEntity.ok().body(obj);
    }

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		return  ResponseEntity.ok().body(obj);

	}
}


