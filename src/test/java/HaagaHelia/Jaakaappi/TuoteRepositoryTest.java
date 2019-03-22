package HaagaHelia.Jaakaappi;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import HaagaHelia.Tuote.domain.Tuote;
import HaagaHelia.Tuote.domain.TuoteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TuoteRepositoryTest {
	@Autowired
	private TuoteRepository repository;
	
	@Test
	public void findByNameShouldReturnTuote() {
		List<Tuote>tuotteet = repository.findByName("MAITO");
		assertThat(tuotteet).hasSize(1);
		assertThat(tuotteet.get(0).getName()).isEqualTo("MAITO");
		
	}
}
