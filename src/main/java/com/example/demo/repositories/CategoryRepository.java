package com.example.demo.repositories;

import com.example.demo.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

	Optional<Category> findByid(Long id);

}
