package com.cubic.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//to add entity annotation we need hibernate-entitymanager in pom file
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
	@Id
	//SequenceGenerator is to use the sequence in the server side
	//to reserve the number for primary keys 
	@SequenceGenerator(name = "cSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	
	@GeneratedValue(generator = "cSeq")
	@Column(name="CUSTOMER_ID")
	private Long pk;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name= "SSN")
	private String ssn;
	
	public Long getPk() {
		return pk;
	}
	public void setPk(Long pk) {
		this.pk = pk;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "CustomerEntity [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn
				+ "]";
	}
	
	
}
