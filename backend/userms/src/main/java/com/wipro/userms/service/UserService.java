package com.wipro.userms.service;
import java.util.List;
import com.wipro.userms.dto.Token;
import com.wipro.userms.entity.User;

public interface UserService {
		String registerUser(User user);
		String registerAdmin(User user);
	    List<User> findAll();
	    User findById(int id);
	    void save(User user);
	    void deleteById(int id);
	    Token login(User user);
		boolean logout(int userId);
	    
	}