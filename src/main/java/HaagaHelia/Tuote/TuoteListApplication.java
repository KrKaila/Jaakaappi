package HaagaHelia.Tuote;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import HaagaHelia.Tuote.domain.CategoryRepository;
import HaagaHelia.Tuote.domain.TuoteRepository;
import HaagaHelia.Tuote.domain.User;
import HaagaHelia.Tuote.domain.UserRepository;

// main-metodi, mikä ajaa koko sovelluksen. Mainiin voi laittaa @Bean -luokan, jos halutaan laittaa kantaan esitietoja (h2)
@SpringBootApplication
public class TuoteListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuoteListApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(TuoteRepository trepository, CategoryRepository crepository, UserRepository urepository) {
		return(args) ->{
					
		};
	}
}
