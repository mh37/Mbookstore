package com.example.mbookstore.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookControllerTest {

    @Autowired
    private BookController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void login() {
    }

    @Test
    void showList() {
    }

    @Test
    void deleteBook() {
    }

    @Test
    void editBook() {
    }

    @Test
    void addBook() {
    }

    @Test
    void newBook() {
    }

    @Test
    void bookListRest() {
    }

    @Test
    void findBookRest() {
    }

    @Test
    void findTitleRest() {
    }
}