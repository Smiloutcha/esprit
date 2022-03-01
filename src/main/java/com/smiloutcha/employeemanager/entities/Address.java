package com.smiloutcha.employeemanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
	
	@Id
	@GeneratedValue
	private Long id;
	private String city ; 
	private Integer zipCode; 

}
