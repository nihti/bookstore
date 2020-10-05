package hh.bookstore;

//import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.test.context.junit4.SpringRunner;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.Category;
import hh.bookstore.domain.CategoryRepository;
import hh.bookstore.domain.UserRepository;
import hh.bookstore.web.BookController;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookStoreApplicationRepositoryTests {
	
	@Autowired
	private BookRepository brepo;
	@Autowired
	private CategoryRepository crepo;
	@Autowired 
	private UserRepository urepo;
	
	/*
	 * Testing repos
	 * */
	@Test
	public void createNewBook() {
		Book book = new Book("Kirja", "Kirjoittaja Kirjailija", new Category("book"));
		brepo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void findBookByTitle() {
		List<Book> books = brepo.findByTitle("Odysseia");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Homeros (suom. Saarikoski)");
	}
	
	@Test
	public void deleteBook() {
		long id = brepo.findByTitle("Odysseia").get(0).getId();
		brepo.deleteById(id);
		assertThat(brepo.findById(id)).isEmpty();
	}
}
