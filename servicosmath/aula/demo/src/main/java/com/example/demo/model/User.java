package main.java.com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String email;
    private String cpf;
    private String addres;
    private Short age;
}
