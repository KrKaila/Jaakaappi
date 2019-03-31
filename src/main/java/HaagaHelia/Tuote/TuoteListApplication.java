package HaagaHelia.Tuote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
private static final Logger log =
LoggerFactory.getLogger(TuoteListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TuoteListApplication.class, args);
	}
	@Bean
	public CommandLineRunner studentDemo(TuoteRepository trepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
	User user1 = new User("USER","user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6");
	User user2 = new User("ADMIN", "admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C");
	urepository.save(user1);
	urepository.save(user2);
	
	for (User user : urepository.findAll()) {
		log.info(user.toString());
	}
	};
	}
	
	
}
