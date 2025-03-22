package com.lcwd.user.service.external.services;

import com.lcwd.user.service.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@Service
@FeignClient(name="RATINGSERVICE")
public interface RatingService {

    //get
    @GetMapping("/ratings")
    Rating getRatings();


    @PostMapping("/ratings")
    public Rating createRatings(Rating values);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String Id,Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public Rating deleteRating(@PathVariable String ratingId);
}
