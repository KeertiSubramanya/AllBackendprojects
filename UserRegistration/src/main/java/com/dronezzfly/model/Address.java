package com.dronezzfly.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String state;
	private String district;
	private String village;
	
//	@ManyToOne
//	@JoinColumn(name="empid")
//	private Employee employee;

}
