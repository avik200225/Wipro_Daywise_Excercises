package com.wipro.userms.service.impl;

import com.wipro.userms.dto.UserNotificationDTO;
import com.wipro.userms.entity.User;
import com.wipro.userms.repo.UserRepository;
import com.wipro.userms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${notification.service.url}")
    private String notifyUrl;

    @Override
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        notify(savedUser, "Created");
        return savedUser;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found with ID: " + id);
        }

        User existingUser = optionalUser.get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setAddress(user.getAddress());

        User updatedUser = userRepository.save(existingUser);
        notify(updatedUser, "Updated");
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found with ID: " + id);
        }

        User existingUser = optionalUser.get();
        userRepository.delete(existingUser);
        notify(existingUser, "Deleted");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found with ID: " + id);
        }

        return optionalUser.get();
    }

    private void notify(User user, String action) {
        UserNotificationDTO dto = new UserNotificationDTO();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setAddress(user.getAddress());
        dto.setAction(action);

        try {
            restTemplate.postForObject(notifyUrl, dto, String.class);
        } catch (Exception e) {
            System.out.println("Failed to notify: " + e.getMessage());
        }
    }
}
