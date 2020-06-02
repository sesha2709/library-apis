package com.fep.micro.libraryapis.libraryapis.publisher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PUBLISHER")
public class PublisherEntity {
	
	
	public PublisherEntity(String name, String email_id, String phone_no) {
		
		
		this.name = name;
		this.email_id = email_id;
		this.phone_no = phone_no;
	}
	
	
	@Column(name="Publisher_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "publisherId_generator")
	@SequenceGenerator(name="publisherId_generator",sequenceName = "publisher_sequence",allocationSize = 50)
	private int publisherId;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email_Id")
	private String email_id;
	
	@Column(name="Phone_Number")
	private String phone_no;
	
	

	public Integer getPublisherId() {
		return publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	
	
	

}
