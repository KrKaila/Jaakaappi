package HaagaHelia.Tuote;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import HaagaHelia.Tuote.web.UserDetailServiceImpl;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	    private UserDetailServiceImpl userDetailsService;	
	 
	 @Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    }
	 
	 @Autowired
	 private HttpSession session;
	 
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http
		//sallii css-muokkauksen kaikilta
		.authorizeRequests()
		.antMatchers("/", "/css/**").permitAll()
		.and()
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		//jos oikea tunnus siirtyy /tuotelistiin
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/tuotelist")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		//.invalidateHttpSession(true);
		
	}
	
	@SuppressWarnings("deprecation")
	@Bean
    @Override
    	public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<UserDetails>();
    	UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

    	users.add(user);
    
    	user = User.withDefaultPasswordEncoder()
               .username("admin")
                   .password("password")
                  .roles("USER", "ADMIN")
                  .build();
    	
    	users.add(user);
    	System.out.println("täällä lisättiin usereita..");
    	
    	for (UserDetails userDetails : users) {
        	System.out.println(userDetails.getPassword());
        	System.out.println(userDetails.getUsername());
			
		}
    	
        return new InMemoryUserDetailsManager(users);
    }
}
