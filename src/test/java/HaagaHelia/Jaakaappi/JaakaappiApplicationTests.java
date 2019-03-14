package HaagaHelia.Jaakaappi;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

//automaattisesti luotu testausluokka
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import HaagaHelia.Jaakaappi.domain.Category;
import HaagaHelia.Jaakaappi.domain.Tuote;
import HaagaHelia.Jaakaappi.domain.TuoteRepository;


//pystyytään käyytämmään vertailumetodeita, laita aina nämä kaksi annotaatiota
@RunWith(SpringRunner.class)
@SpringBootTest
public class JaakaappiApplicationTests {
//myös tämä pitää laittaa
	
    @Autowired
    private TuoteRepository repository;

    @Test
    public void findByNameShouldReturnTuote() {
        List<Tuote> tuotteet = repository.findByNameIgnoreCase("Maito");
        
        assertThat(tuotteet).hasSize(1);
       
    }
    
   
	@Test
	public void contextLoads() {
		
	}

}
