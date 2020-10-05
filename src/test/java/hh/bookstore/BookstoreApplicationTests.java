package hh.bookstore;

//import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.Category;
import hh.bookstore.domain.CategoryRepository;
import hh.bookstore.domain.UserRepository;
import hh.bookstore.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	/*
	 * Testing controller
	 * */
	@Autowired 
	private BookController controller;
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
}

/*
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookstoreApplicationTests {

	@Test
	void contextLoads() {
	}

}
*/