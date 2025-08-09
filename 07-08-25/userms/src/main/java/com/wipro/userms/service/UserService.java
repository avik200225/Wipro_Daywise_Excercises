package com.wipro.userms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.userms.dto.UserNotificationDTO;
import com.wipro.userms.entity.User;
import com.wipro.userms.repo.UserRepository;

public interface UserService {
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
    User getUserById(Long id);
}

