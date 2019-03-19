package HaagaHelia.Jaakaappi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import HaagaHelia.Jaakaappi.domain.Category;
import HaagaHelia.Jaakaappi.domain.CategoryRepository;
import HaagaHelia.Jaakaappi.domain.Tuote;
import HaagaHelia.Jaakaappi.domain.TuoteRepository;

// main-metodi, mikä ajaa koko sovelluksen. Mainiin voi laittaa @Bean -luokan, jos halutaan laittaa kantaan esitietoja (h2)
@SpringBootApplication
public class JaakaappiApplication {
	private static final Logger log = LoggerFactory.getLogger(JaakaappiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JaakaappiApplication.class, args);
	}
	//@SuppressWarnings("deprecation")
	@Bean
	public CommandLineRunner demo(TuoteRepository trepository, CategoryRepository crepository) {
		return(args) ->{
			log.info("save categories");
			crepository.save(new Category("IT"));
			crepository.save(new Category("BUSI"));
			crepository.save(new Category("LAKI"));
			
			log.info("save products and categories");
			
			trepository.save(new Tuote("MAITO"));
			trepository.save(new Tuote("JUUSTO"));	
			trepository.save(new Tuote("KALJA"));
			log.info("fetch products and categories");					
			for (Tuote tuote : trepository.findAll()) {
			
			log.info(tuote.toString());
			}
		};
	}
}
