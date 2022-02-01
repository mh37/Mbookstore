package com.example.mbookstore.dao;

import java.sql.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseApi implements CommandLineRunner {
    // Use Spring Boot @autowired automatically wire the object using application.properties:
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void deleteRecord(String title) {
        final String deleteSql = "DELETE FROM book WHERE title = ?";
        // query arguments
        Object[] params = { title };
        // SQL types of the arguments
        int[] types = { Types.VARCHAR };
        int rows = this.jdbcTemplate.update(deleteSql, params, types);
        //Log it to the console
        System.out.print("Deleted Book named: "+title);
    }

    //Update Query
    // this.jdbcTemplate.update(
    // “UPDATE book SET title = ?,author = ? ..... WHERE title = ?”,
    // author, year, isbn...);

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("The server has successfully started");
    }
    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
    }
}