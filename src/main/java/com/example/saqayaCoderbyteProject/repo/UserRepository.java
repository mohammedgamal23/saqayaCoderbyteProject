package com.example.saqayaCoderbyteProject.repo;

import com.example.saqayaCoderbyteProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

}
