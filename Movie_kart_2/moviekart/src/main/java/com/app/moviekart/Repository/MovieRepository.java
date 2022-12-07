package com.app.moviekart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.moviekart.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	

}
