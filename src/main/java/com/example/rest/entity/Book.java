package com.example.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

	
	@Id
	private int id;
	private String name;
	@OneToOne(cascade =  CascadeType.ALL)
	private Auther author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Auther getAuthor() {
		return author;
	}
	public void setAuthor(Auther author) {
		this.author = author;
	}
	
	
}
