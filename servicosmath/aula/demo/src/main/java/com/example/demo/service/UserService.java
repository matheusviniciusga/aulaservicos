package main.java.com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.example.demo.exception.UserNotFoundException;
import main.java.com.example.demo.model.User;
import main.java.com.example.demo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository ur;

    public User addUser(User u) {
        return ur.save(u);
    }

    public void deleteUser(User u) {
        ur.delete(u);
    }

    public List<User> searchAllUsers() {
        return ur.findAll();
    }

    public User updateUser(Long id, User newUser) throws UserNotFoundException {
        Optional<User> opUser = ur.findById(id);

        if(opUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        User u = opUser.get();
        u.setUsername(newUser.getUsername());
        u.setPassword(newUser.getPassword());
        u.setEmail(newUser.getEmail());
        u.setCpf(newUser.getCpf());
        u.setPassword(newUser.getAddres());
        u.setAge(newUser.getAge());

        return ur.save(u);
    }

    public User login(String username, String password) throws UserNotFoundException {
        User us = ur.findByUsernameAndPassword(username, password);

        if(us != null) {
            return us;
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
