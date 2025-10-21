package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "usuario")
public class User implements Serializable {
	
   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
   private String email;
   private String phone;
   private String passsword; 
   


 public User(long id, String name, String email, String phone, String passsword) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.passsword = passsword;
 }

 public User(Object object, String name2, String email2, String phone2, String passsword2) {
	// TODO Auto-generated constructor stub
}

 public long getId() {
	return id;
 }

 public void setId(long id) {
	this.id = id;
 }

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }

 public String getEmail() {
	return email;
 }

 public void setEmail(String email) {
	this.email = email;
 }

 public String getPhone() {
	return phone;
 }

 public void setPhone(String phone) {
	this.phone = phone;
 }

 public String getPasssword() {
	return passsword;
 }

 public void setPasssword(String passsword) {
	this.passsword = passsword;
 }

 @Override
 public int hashCode() {
	return Objects.hash(id);
 }

 @Override
 public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return id == other.id;
 }
 
}
