package com.example.medicare.repository.users;

import com.example.medicare.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Override
    Optional<Users> findById(Integer userId);

    Optional<Users> findByEmail(String email);
}
