package com.example.mbookstore;

import com.example.mbookstore.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;


@SpringBootApplication
public class MbookstoreApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(MbookstoreApplication.class, args);
	}
//TODO --> I should put an ID field in the table (PK)
	@Override
	public void run(String... args) throws Exception {
		//Create the table if it doesn't exist
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS book(" +  //TODO --> lets move table name to a global variable
				"title VARCHAR(100)," +
				"author VARCHAR(100)," +
				"year INTEGER," +
				"isbn VARCHAR(22)," +
				"price DOUBLE," +
				"inventory INTEGER)");
		//Insert test entry
		//jdbcTemplate.execute("INSERT INTO book values ('Testing Tests','John Tester','2000','ISBN 978-3-16-148410-0','20.00','10')");
		//Read book list from DB
		List<Book> books = jdbcTemplate.query("SELECT * FROM book", //TODO --> lets move table name to a global variable
				(resultSet, rowNum) -> new Book(resultSet.getString("title")
						,resultSet.getString("author")
						,resultSet.getInt("year")
						,resultSet.getString("isbn")
						,resultSet.getDouble("price")
						,resultSet.getInt("inventory")));
		//Print records
		books.forEach(System.out::println);
	}
}