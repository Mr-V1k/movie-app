package com.freecodecamp.movieserver.Controller;

import com.freecodecamp.movieserver.Model.Review;
import com.freecodecamp.movieserver.Service.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<String> hiFromReview(){
        return new ResponseEntity<String>("Hi", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(
                reviewService.createReview(
                        payload.get("reviewBody"),
                        payload.get("imdbId")
                ),
                HttpStatus.CREATED
        );
    }
}
