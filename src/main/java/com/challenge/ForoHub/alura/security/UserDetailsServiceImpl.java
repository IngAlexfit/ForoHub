package com.challenge.ForoHub.alura.security;

import com.challenge.ForoHub.alura.model.User;
import com.challenge.ForoHub.alura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
        User user = userRepository.findByCorreoElectronico(correoElectronico);
        if (user == null) {
            throw new UsernameNotFoundException(correoElectronico);
        }
        return new org.springframework.security.core.userdetails.User(user.getCorreoElectronico(), user.getContrasena(), new ArrayList<>());
    }
}