package HaagaHelia.Tuote.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//linkittää luokkien nimet tietokannan nimiin. Crudrepositorissa on toiminnot valmiiksi muokkauksia varten
public interface TuoteRepository extends CrudRepository<Tuote, Long> {
	
	List<Tuote> findByName(String name);

}
