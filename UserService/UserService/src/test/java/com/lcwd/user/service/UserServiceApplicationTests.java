package com.lcwd.user.service;

import com.lcwd.user.service.external.services.RatingService;
import com.lcwd.user.service.model.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void createRatings(){
//	Rating rating= Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using Feign Client").build();
//	Rating saveRating= ratingService.createRatings(rating);
//
//		System.out.println("New Rating Created");
//	}

}
