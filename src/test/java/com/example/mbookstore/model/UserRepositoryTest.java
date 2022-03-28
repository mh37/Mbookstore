package com.example.mbookstore.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void saveUser() {
        User u = new User("test", "", "USER");
        repository.save(u);
        assertThat(u.getId()).isNotNull();
    }

    @Test
    public void deleteUser() {
        User u = new User("TestUser", "", "USER");;
        repository.save(u);
        repository.delete(u);
        User newU = repository.findByUsername("TestUser");
        assertThat(newU).isNull();
    }

    @Test
    public void findUserName() {
        User u = repository.findByUsername("user");
        assertThat(u).isNotNull();
        assertThat(u.getUsername()).isEqualTo("user");
    }
}