package com.example.mbookstore.service;

import java.util.List;
import com.example.mbookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class DBService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Book> getData(){
        String selectSql = "SELECT * FROM book";  // TODO --> lets move the table name later to a global variable
        List<Book> insertedRows = jdbcTemplate.query(selectSql, //TODO --> I should put an ID field here
                (resultSet, rowNum) -> new Book(resultSet.getString("title")
                                                ,resultSet.getString("author")
                                                ,resultSet.getInt("year")
                                                ,resultSet.getString("isbn")
                                                ,resultSet.getDouble("price")
                                                ,resultSet.getInt("inventory")));
        return insertedRows;
    }
}