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
import hh.bookstore.domain.User;
import hh.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner bookstore(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
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
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			Log.info("list all books");
			for (Book book : repository.findAll()) {
				Log.info(book.toString());
			}
		};
	}
	
	
	// hibernate does not exist 

}
