package hh.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	// Spring security uses this method and it's mandatory
	User findByUsername(String username);
}
