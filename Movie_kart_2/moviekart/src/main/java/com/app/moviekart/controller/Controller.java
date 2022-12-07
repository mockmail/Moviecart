package com.app.moviekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.moviekart.model.Movie;
import com.app.moviekart.model.Review;
import com.app.moviekart.service.MovieService;
import com.app.moviekart.service.ReviewService;

class ReviewComments
{
	public long movie_id;
	
	public List<String> comments;
}
@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private MovieService movieservice;
	
	
	@Autowired
	private ReviewService reviewservice;
	
	@RequestMapping("/movies/{id}")
    public Movie getMoviePreview(@PathVariable("id") long id) throws Exception {
      
            //System.out.println("MOVIE ID: "+id);
            Movie movie = movieservice.getMovieById(id);
            
        return movie;
    }
	@PostMapping("/smovie")
	public ResponseEntity<Movie> saveMovieData(@RequestBody  Movie movie) 
	{
		return new ResponseEntity<Movie>(movieservice.saveMovie(movie),HttpStatus.CREATED);
		
	}
     
	@PostMapping("/sreview")
	public ResponseEntity<Review> saveReviewData(@RequestBody ReviewComments comment) throws Exception
	{
		//Review review;
		Review review = new Review();
		review.setMovie(movieservice.getMovieById(comment.movie_id));
		review.setComments(comment.comments);
		return new ResponseEntity<Review>(reviewservice.saveNewReview(review),HttpStatus.CREATED);
	}
	

	
	
	
}
