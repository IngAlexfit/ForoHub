package com.challenge.ForoHub.alura.repository;

import com.challenge.ForoHub.alura.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCorreoElectronico(String correoElectronico);
}