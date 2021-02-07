package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Personal_Service {
	
	@Autowired
	private Personal_Repository personalrepository;
	
	
	@GetMapping(path = "/menu" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Personal> getMenu() {
		return personalrepository.findAll();
	}
	
	@GetMapping(path = "/Menu/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Personal getOneUbung(@PathVariable(value = "id") Long id) {
		return personalrepository.findById(id).get();
	}
	
	@GetMapping(path = "/Menu/getName/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Personal getOneMenu(@PathVariable(value = "name") String name) {
		return personalrepository.findByName(name);
	}
	
	@PostMapping(path = "/menu", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Personal save(@RequestBody Personal personal) {
		return personalrepository.save(personal);
	}
	
	@PutMapping(path = "/personal/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Personal save(@RequestBody Personal personal, @PathVariable(value = "matrikelNr") Long matrikelNr) {
		personal.setMatrikelNr(matrikelNr);
		return personalrepository.save(personal);
	}
	
	@DeleteMapping(path = "/menu/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public boolean delete(@PathVariable Long id) {
		
		try {
			personalrepository.deleteById(id);
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	
    @PostMapping(path = "/personal" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public Personal save2 (@RequestBody Personal personal ) {
    	  String passwortString = personal.getPassword();
    	  Long matrieklnummerLong = personal.getMatrikelNr();
    	  Personal personal2 = personalrepository.findByMatrikelNr(personal.getMatrikelNr());
    	  if (personal2 != null) {
			if ( personal2.getPassword().equalsIgnoreCase(passwortString) ) {
				return personal2;
			}
		}
    	  return new Personal(0L,null,null,null);
       }

}
