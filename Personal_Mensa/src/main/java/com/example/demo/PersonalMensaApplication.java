package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PersonalMensaApplication implements CommandLineRunner{
	@Autowired
	private Personal_Repository personal_Repository;
	

	public static void main(String[] args) {
		SpringApplication.run(PersonalMensaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { 
		// TODO Auto-generated method stub
		personal_Repository.save(new Personal(236L, "Mueller","Mueller123", "Admin"));
		personal_Repository.save(new Personal(235L,"Stuerzel","Stuerzel123", "User"));
		personal_Repository.save(new Personal(334L,"Koch","Koch123","Mitarbeiter"));
		
		
		
		for (Personal personal : personal_Repository.findAll()) {
			System.out.println(personal.toString());
		}
		
	}

}
