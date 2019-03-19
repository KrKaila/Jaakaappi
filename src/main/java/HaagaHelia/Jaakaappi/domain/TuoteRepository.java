package HaagaHelia.Jaakaappi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
//linkittää luokkien nimet tietokannan nimiin. Crudrepositorissa on toiminnot valmiiksi muokkauksia varten
public interface TuoteRepository extends CrudRepository<Tuote, Long> {
	
	List<Tuote> findByName(String name);

}
