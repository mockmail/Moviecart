package com.app.moviekart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="Movie",uniqueConstraints=@UniqueConstraint(name="movie_name_unique",columnNames="name"))
public class Movie 
{
	@Id
	@SequenceGenerator(name="movie_id_sequence",sequenceName="movie_id_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="movie_id_sequence")
	@Column(updatable=false)
	private long movie_id;
	
	@JsonProperty
	@Column(name="name",nullable=true,columnDefinition="TEXT")
    private String name;
	
	//@JsonSerialize(as=MyInterface.class)
	@OneToMany(cascade=CascadeType.ALL,
			fetch=FetchType.LAZY,
			mappedBy="movie")
	private List<Review> reviews;
	
	public Movie() {
		
	}

	public Movie(long id, String name) {
		super();
		this.movie_id = id;
		this.name = name;
		
	}

	public long getId() {
		return movie_id;
	}

	public void setId(long id) {
		this.movie_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Movie [id=" + movie_id + ", name=" + name + "]";
	}

//	public Movie(long id, String name, List<Review> reviews) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.reviews = reviews;
//	}
//
//	@Override
//	public String toString() {
//		return "Movie [id=" + id + ", name=" + name + ", reviews=" + reviews + "]";
//	}
	

	
}
