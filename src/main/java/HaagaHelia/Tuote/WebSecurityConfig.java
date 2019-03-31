package HaagaHelia.Tuote;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import HaagaHelia.Tuote.web.UserDetailServiceImpl;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	    private UserDetailServiceImpl userDetailsService;	
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http
		//sallii css-muokkauksen kaikilta
		.authorizeRequests()
		.antMatchers("/", "/css/**").permitAll()
		.and()
		.authorizeRequests()
		.anyRequest().permitAll()
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
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); 
	}
	}
      
		