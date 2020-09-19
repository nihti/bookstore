package hh.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.Category;
import hh.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner bookstore(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			Log.info("create book categories");
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Fact"));
			crepository.save(new Category("Poetry"));
			
			
			Log.info("create a couple of books");
			//public Book(String title, String author, String isbn, int year, double price) 
			repository.save(new Book("Näkymättömät kaupungit", "Italo Calvino", crepository.findByName("Fiction").get(0)));
			repository.save(new Book("Odysseia", "Homeros (suom. Saarikoski)", crepository.findByName("Poetry").get(0)));
			repository.save(new Book("Andalusian lauluja", "Federico Garcia Lorca (suom. Rossi", crepository.findByName("Poetry").get(0)));
			
			Log.info("list all books");
			for (Book book : repository.findAll()) {
				Log.info(book.toString());
			}
		};
	}
	
	
	// hibernate does not exist 

}
