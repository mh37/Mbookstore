package com.example.mbookstore;

import com.example.mbookstore.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MbookstoreApplication{

	public static void main(String[] args) {
		SpringApplication.run(MbookstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return args -> {
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Sci-Fi"));
			crepository.save(new Category("History"));

			//for (Category c : crepository.findAll()) {
			//	System.out.println(c.toString());
			//}


			//repository.save(new Book("Testing Tests","John Tester",2000,crepository.findByName("Horror").get(0),"978-3-16-148410-0",20.00,10));
			//repository.save(new Book("Testers Tests","Frank Tester",2020,crepository.findByName("History").get(0),"971-3-17-148510-0",29.90,100));
			//repository.save(new Book("Test of all Tests","Peter Testerman",2021,crepository.findByName("Sci-Fi").get(0),"971-3-17-158511-0",25.95,40));

			// Create users: admin/admin user/user
			//User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			//urepository.save(user1);
			urepository.save(user2);

			//for (Book b : repository.findAll()) {
			//	System.out.println(b.toString());
			//}
		};
	}
}