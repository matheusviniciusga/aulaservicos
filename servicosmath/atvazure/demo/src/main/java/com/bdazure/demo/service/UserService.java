package main.java.com.bdazure.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.bdazure.demo.model.User;
import main.java.com.bdazure.demo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Optional<User> opUser = userRepository.findById(id);

        if(opUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            System.out.println("User not found");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User newUser) {
        Optional<User> opUser = userRepository.findById(id);

        if(opUser.isEmpty()) {
            return null;
        }

        User user = opUser.get();
        user.setName(newUser.getName());
        return userRepository.save(newUser);
    }
}
