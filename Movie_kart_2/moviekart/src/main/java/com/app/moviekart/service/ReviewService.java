package com.app.moviekart.service;

import org.springframework.stereotype.Service;

import com.app.moviekart.model.Review;

@Service
public interface ReviewService {
	public Review saveNewReview(Review review);
	
	public void deleteReview(Long id);
	
	public Review getSingleReview(Long id);

}
