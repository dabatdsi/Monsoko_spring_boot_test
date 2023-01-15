package com.gestionemployee.gestionemployee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//@EnableGlobalMethodSecurity(prePostEnabled = true , securedEnabled = true)
public class GestionemployeeApplication   {
	public static void main(String[] args) {

		SpringApplication.run(GestionemployeeApplication.class, args);

	}
	/*@Bean
	public BCryptPasswordEncoder getBCPE(){

		return new BCryptPasswordEncoder();
	}*/


	}


