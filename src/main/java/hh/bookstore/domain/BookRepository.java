package hh.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
	// https://spring.io/guides/tutorials/rest/ 
	List<Book> findByTitle(@Param("title") String Title);
}
