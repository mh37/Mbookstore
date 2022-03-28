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
class CategoryRepositoryTest {


    @Autowired
    private CategoryRepository repository;

    @Test
    public void saveBook() {
        Category c = new Category("Test Category");
        repository.save(c);
        assertThat(c.getCategoryid()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        Category c = new Category("Test");
        repository.save(c);
        repository.delete(c);
        List<Category> newC = repository.findByName("Test");
        assertThat(newC).hasSize(0);
    }

    @Test
    public void findCategory() {
        List<Category> categories = repository.findByName("Horror");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Horror");
    }
}