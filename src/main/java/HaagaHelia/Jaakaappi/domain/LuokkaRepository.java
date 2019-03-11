package HaagaHelia.Jaakaappi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface LuokkaRepository extends CrudRepository<Luokka, Long> {
	List<Luokka> findByName(String luokka);

}
