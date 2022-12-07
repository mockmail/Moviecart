package com.app.moviekart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.moviekart.model.Movie;

@Service
public interface MovieService {
	
	Movie saveMovie(Movie movie);
	
	List<Movie> getMovies();
	
	void deleteMovie(Movie movie);
	
	Movie getMovieById(Long Id) throws Exception;

}
