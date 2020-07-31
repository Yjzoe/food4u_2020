package com.remake.food4u.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findAllByRole(String role);
    Optional<User> findByEmail(String email);

}