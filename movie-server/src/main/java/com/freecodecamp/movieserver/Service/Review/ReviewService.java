package com.freecodecamp.movieserver.Service.Review;

import com.freecodecamp.movieserver.Model.Movie;
import com.freecodecamp.movieserver.Model.Review;
import com.freecodecamp.movieserver.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId){
        // Create a new review
        Review review = reviewRepository.insert(new Review(reviewBody));
        // Create a custom constructor for review body -> done
        // Associate to the imdbId movies
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
