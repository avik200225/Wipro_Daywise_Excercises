package com.wipro.userms.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

   
    @Entity
    @Table(name="user_data")
    @Data
    public class User {
    	
    	@Id
    	@GeneratedValue(strategy=GenerationType.IDENTITY)
    	int id;
    	
    	@Column(name="username")
    	String username;
    	
    	@Column(name="password")
    	String password;
    	
    	@Column(name="address")
    	String address;
}