package com.app.moviekart.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="Reviews")
public class Review
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @SequenceGenerator(initialValue = 1,name = "req_seq", sequenceName = "review_sequence")
    private Long review_id;
   
	@JsonIgnore
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="movie_id",nullable=false)
   private Movie movie;
  
	@JsonProperty
   @ElementCollection
	private List<String> comments;

public Long getReview_id() 
{
	return review_id;
}

public void setReview_id(Long review_id) 
{
	this.review_id = review_id;
}

public Movie getMovie() 
{
	return movie;
}

public void setMovie(Movie movie) 
{
	this.movie = movie;
}

public List<String> getComments() 
{
	return comments;
}

public void setComments(List<String> comments) 
{
	this.comments = comments;
}
   
   

}
