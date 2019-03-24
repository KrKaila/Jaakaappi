package HaagaHelia.Tuote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import HaagaHelia.Tuote.domain.Category;
import HaagaHelia.Tuote.domain.CategoryRepository;
import HaagaHelia.Tuote.domain.Tuote;
import HaagaHelia.Tuote.domain.TuoteRepository;
import HaagaHelia.Tuote.domain.User;
import HaagaHelia.Tuote.domain.UserRepository;

// main-metodi, mikä ajaa koko sovelluksen. Mainiin voi laittaa @Bean -luokan, jos halutaan laittaa kantaan esitietoja (h2)
@SpringBootApplication
public class TuoteListApplication {
	private static final Logger log =
LoggerFactory.getLogger(TuoteListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TuoteListApplication.class, args);
	}
	@SuppressWarnings("deprecation")
	@Bean
	public CommandLineRunner demo(TuoteRepository trepository, CategoryRepository crepository, UserRepository urepository) {
		return(args) ->{
			
		};
	}
}
