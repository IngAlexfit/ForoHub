package com.challenge.ForoHub.alura.service;

import com.challenge.ForoHub.alura.model.User;
import com.challenge.ForoHub.alura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public User registerUser(User user) {
        if (userRepository.findByCorreoElectronico(user.getCorreoElectronico()) != null) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }
        user.setContrasena(passwordEncoder.encode(user.getContrasena()));
        return userRepository.save(user);
    }

    public Optional<User> findByCorreoElectronico(String correoElectronico) {
        return Optional.ofNullable(userRepository.findByCorreoElectronico(correoElectronico));
    }

}