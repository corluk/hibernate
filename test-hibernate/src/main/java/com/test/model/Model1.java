package com.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

 
@Entity 
@Table(name="model1")
public class Model1 {
	@Id
	@Column(unique=true,columnDefinition="serial")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column
	String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cdate" )
	Date cdate = new Date(); 
	
	@OneToOne
	@JoinColumn(name="id")
	private Model1_OneToOne model1_onetoone;
	
	
	public Model1_OneToOne getModel1_onetoone() {
		return model1_onetoone;
	}


	public void setModel1_onetoone(Model1_OneToOne model1_onetoone) {
		this.model1_onetoone = model1_onetoone;
	}


	public Date getCdate() {
		return cdate;
	}
 

	public void setCdate(Date cdate) {
		this.cdate = cdate;
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
	
	
}
