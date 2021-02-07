package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Personal {
	
	@Id
	Long matrikelNr;
	String name;
	String password;
	String Role;
	
	public Long getMatrikelNr() {
		
		
		return matrikelNr;
	}
	public Personal() {
		
	}
	@Override
	public String toString() {
		return "Personal [matrikelNr=" + matrikelNr + ", name=" + name + ", password=" + password + ", Role=" + Role
				+ "]";
	}
	public Personal(Long matrikelNr, String name, String password, String role) {
		
		this.matrikelNr = matrikelNr;
		this.name = name;
		this.password = password;
		Role = role;
	}
	public void setMatrikelNr(Long matrikelNr) {
		this.matrikelNr = matrikelNr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}

}
