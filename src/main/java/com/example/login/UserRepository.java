package com.example.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM users u WHERE u.email = ?1")
    User findByEmail(String email);
}
