package com.freecodecamp.movieserver.Service.Movie;

import com.freecodecamp.movieserver.Model.Movie;
import org.bson.types.ObjectId;

import java.util.List;

public interface IMovieService {
    List<Movie> allMovies();

    Movie getMovieByImdbId(String id);

}
