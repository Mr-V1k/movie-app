package com.freecodecamp.movieserver.Service.Review;

import com.freecodecamp.movieserver.Model.Review;

public interface IReviewService {
    Review createReview(String reviewBody, String imdbId);
}
