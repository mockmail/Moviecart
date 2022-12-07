package com.app.moviekart.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.moviekart.Repository.ReviewRepository;
import com.app.moviekart.model.Review;
import com.app.moviekart.service.ReviewService;

@Component
public class ReviewServiceimpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewrepository;

	@Override
	public Review saveNewReview(Review review) {
		// TODO Auto-generated method stub
		
		return reviewrepository.save(review);
	}

	@Override
	public void deleteReview(Long id) {
		// TODO Auto-generated method stub
		
		reviewrepository.deleteById(id);
		
	}

	@Override
	public Review getSingleReview(Long id) {
		// TODO Auto-generated method stub
		return reviewrepository.findById(id).orElse(new Review());
	}
	
	
}
