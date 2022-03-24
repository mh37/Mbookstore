package com.example.mbookstore;

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
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository repository;

    @Test
    public void saveBook() {
        Book book = new Book("This is a Book", "John Johnson", 2020, new Category("Test"),"ISBN3838383",20.00,11);
        entityManager.persistAndFlush(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBooks() {
        entityManager.persistAndFlush(new Book("This is a Book", "John Johnson", 2020, new Category("Test"),"ISBN3838383",20.00,11));
        entityManager.persistAndFlush(new Book("This is also a Book", "John Johnson", 2021, new Category("Testing"),"ISBN3111383",10.00,1));
        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }






    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Test");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Test");
    }

    @Test
    void findByTitle() {
    }

}



