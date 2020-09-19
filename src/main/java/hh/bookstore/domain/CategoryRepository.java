package hh.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	// findBy ITSE LUOTU MUUTTUJA 
	List<Category> findByName(String name);
}
