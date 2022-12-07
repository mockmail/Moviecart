package com.app.moviekart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.moviekart.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
