package com.example.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testUserGen() {
        User user = new User();
        user.setEmail("himym2603@gmail.com");
        user.setPassword("987654321");
        user.setFirstName("Long");
        user.setLastName("Ngoc");

        User savedUser = repository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertEquals(existUser.getEmail(), user.getEmail());
    }


    @Test
    public void testFindUserByMail() {
        String emaill = "luongbui263@gmail.com";
        User user = repository.findByEmail(emaill);

        assertNotNull(user);
    }
}