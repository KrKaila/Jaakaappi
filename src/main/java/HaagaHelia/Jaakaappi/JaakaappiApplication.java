package HaagaHelia.Jaakaappi;

import java.sql.Date;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import HaagaHelia.Jaakaappi.domain.Luokka;
import HaagaHelia.Jaakaappi.domain.LuokkaRepository;
import HaagaHelia.Jaakaappi.domain.Tuote;
import HaagaHelia.Jaakaappi.domain.TuoteRepository;
import HaagaHelia.Jaakaappi.domain.User;
// main-metodi, mikä ajaa koko sovelluksen. Mainiin voi laittaa @Bean -luokan, jos halutaan laittaa kantaan esitietoja (h2)
import HaagaHelia.Jaakaappi.domain.UserRepository;


@SpringBootApplication
public class JaakaappiApplication {
	private static final Logger log = LoggerFactory.getLogger(JaakaappiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JaakaappiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TuoteRepository trepository, LuokkaRepository lrepository, UserRepository urepository){
		return(args) ->{
						
			User user1 =new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER");
			User user2 =new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all products");
			for (Tuote tuote : trepository.findAll()) {
				log.info(tuote.toString());
			}
	};
	}

}
