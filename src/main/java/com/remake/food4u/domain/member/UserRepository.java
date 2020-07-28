package com.remake.food4u.domain.member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findAllByRole(String role);
    Optional<User> findByEmail(String email);

}