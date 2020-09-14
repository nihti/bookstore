package hh.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository repository) {
		return (args) -> {
			Log.info("create a couple of books");
			// public Book(String title, String author, String isbn, int year, double price) 
			repository.save(new Book("Näkymättömät kaupungit", "Italo Calvino", "951-30-3270-1", 1972, 10.5));
			repository.save(new Book("Odysseia", "Homeros (suom. Saarikoski)", "951-1-17050-3", 1972, 10.5));
			repository.save(new Book("Andalusian lauluja", "Federico Garcia Lorca (suom. Rossi", "951-1-00116-7", 1982, 5.5));
			
			Log.info("list all books");
			for (Book book : repository.findAll()) {
				Log.info(book.toString());
			}
		};
	}

}
