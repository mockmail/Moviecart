package com.app.moviekart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.moviekart.Repository.MovieRepository;
import com.app.moviekart.model.Movie;
import com.app.moviekart.service.MovieService;

@Component
public class MovieServiceimpl  implements MovieService{

	
	@Autowired
	private MovieRepository movierepository;
	@Override
	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movierepository.save(movie);
		
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return movierepository.findAll();
	}

	@Override
	public void deleteMovie(Movie movie) {
		// TODO Auto-generated method stub
		
		movierepository.delete(movie);
		
	}

	@Override
	public Movie getMovieById(Long Id) throws Exception {
		// TODO Auto-generated method stub
		return movierepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Invalid Movie id:"+Id));
	}
	
}
