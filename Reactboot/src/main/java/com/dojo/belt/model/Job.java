package com.dojo.belt.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "job")

public class Job {
	

	@Id
	@GeneratedValue
	private Long id;
	
	private String jobType;
	private double fee; 
	@Temporal(TemporalType.DATE)
    Date publicationDate;
	
	
	@ManyToMany(mappedBy = "jobs", fetch= FetchType.LAZY)

	@JsonBackReference
	private Set<User> users;
	
	public Job() {
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getJobType() {
		return jobType;
	}


	public void setJobType(String jobType) {
		this.jobType = jobType;
	}


	public double getFee() {
		return fee;
	}


	public void setFee(double fee) {
		this.fee = fee;
	}


	public Date getPublicationDate() {
		return publicationDate;
	}


	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
