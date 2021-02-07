package com.example.demo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface Personal_Repository extends JpaRepositoryImplementation<Personal, Long> {
	
   public Personal findByName(String Name);
   public Personal findByMatrikelNr(long matrikelnummer);
   public Personal findByPassword(String password);
}
