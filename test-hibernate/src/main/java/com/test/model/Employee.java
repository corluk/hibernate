package com.test.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee") 
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id; 
	
	@Column
	private String name; 
	
	@OneToOne
	@JoinColumn(name="address_id")
	Address address;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="employer_id")
	private Set<Task> tasks; 
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;
	
	@OneToMany(mappedBy="manager")
	private Set<Employee> subOrdinates = new HashSet<Employee>();
	
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getSubOrdinates() {
		return subOrdinates;
	}

	public void setSubOrdinates(Set<Employee> subOrdinates) {
		this.subOrdinates = subOrdinates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
