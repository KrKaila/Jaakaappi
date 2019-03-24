package HaagaHelia.Tuote.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends CrudRepository<User, Long> {
	List<UserDetails> findByUsername(String username);
}
