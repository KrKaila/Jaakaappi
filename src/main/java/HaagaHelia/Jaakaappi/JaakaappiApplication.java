package HaagaHelia.Jaakaappi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import HaagaHelia.Jaakaappi.domain.CategoryRepository;
import HaagaHelia.Jaakaappi.domain.Tuote;
import HaagaHelia.Jaakaappi.domain.TuoteRepository;

// main-metodi, mikä ajaa koko sovelluksen. Mainiin voi laittaa @Bean -luokan, jos halutaan laittaa kantaan esitietoja (h2)
import HaagaHelia.Jaakaappi.domain.UserRepository;


@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class JaakaappiApplication {
	private static final Logger log = LoggerFactory.getLogger(JaakaappiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JaakaappiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TuoteRepository trepository, CategoryRepository crepository, UserRepository urepository){
		return(args) ->{
	};
	}
}
