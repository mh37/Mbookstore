package com.example.mbookstore.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.mbookstore.model.Book;
import com.example.mbookstore.model.BookRepository;
import com.example.mbookstore.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void saveBook() {
        Book book = new Book("This is a Book", "John Johnson", 2020, new Category("Test"),"ISBN3838383",20.00,11);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBooks() {
        Book book = new Book("Test Book", "John Johnson", 2020, new Category("Test"),"ISBN3838383",20.00,11);
        repository.save(book);
        repository.delete(book);
        List<Book> newBooks = repository.findByTitle("Test Book");
        assertThat(newBooks).hasSize(0);
    }

    @Test
    public void searchBook() {
        List<Book> books = repository.findByTitle("Testing Tests");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Testing Tests");
    }
}



