package main.java.com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.example.demo.DTO.User.UserLogin;
import main.java.com.example.demo.exception.UserNotFoundException;
import main.java.com.example.demo.model.User;
import main.java.com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService us;

    @PostMapping("/add")
    public User postUser(@RequestBody User u) {
        return us.addUser(u);
    }

    @DeleteMapping("delete/{id}")
    public void removeUser(User u) {
        us.deleteUser(u);
    }

    @GetMapping("/all");
    public List<User> getAllUsers() {
        return us.searchAllUsers();
    }

    @PutMapping("/update/{id}");
    public User changeUser(@PathVariable Long id, @RequestBody User u) throws UserNotFoundException {
        try{
            return us.updateUser(id, u);
        } catch(UserNotFoundException ue) {
            throw new UserNotFoundException("User not found");
        }
    }

    @PostMapping("/login/{id}");
    public boolean userLogin(@RequestBody UserLogin u) throws UserNotFoundException {
        String username = u.getUsername();
        String password = u.getPassword();

        try{
            User uLogin = us.login(username, password);
            return true;
        } catch(UserNotFoundException ue) {
            throw new UserNotFoundException("User not found.");
        }
    }
}
