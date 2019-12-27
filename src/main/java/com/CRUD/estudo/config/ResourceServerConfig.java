package com.CRUD.estudo.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableWebSecurity

public class ResourceServerConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        auth.inMemoryAuthentication()
	          .withUser("admin")
	          .password(encoder.encode("admin"))
	          .roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/categorias", "/lancamentos", "/pessoas").permitAll()
			.anyRequest().authenticated()
			.and()
			.httpBasic().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.csrf().disable(); 
	}
	
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                       .allowedOrigins("http://localhost:4200/")
	                       .allowedMethods("GET", "POST", "PUT", "DELETE")
	                       .allowedHeaders("Content-Type", "Authorization");
	    }
	
	 @Component
	 public class Scheduler {
	    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	 @Scheduled(fixedRate  = 5000)
	    public void task() {
	       System.out.println("Scheduler task with duration : " + sdf.format(new Date()));
	       // throw new RuntimeException("Example to throw a runtime exception");
	    }
	 }
	
	}


