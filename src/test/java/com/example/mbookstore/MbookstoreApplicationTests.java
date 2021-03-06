package com.example.mbookstore;

import com.example.mbookstore.controller.BookController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MbookstoreApplicationTests {

	@Autowired
	private BookController bcontroller;


	@Test
	public void contextLoads() throws Exception {
		assertThat(bcontroller).isNotNull();
	}

}
