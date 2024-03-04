package com.freecodecamp.movieserver.Service.Movie;

import com.freecodecamp.movieserver.Model.Movie;
import com.freecodecamp.movieserver.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieByImdbId(String id){
        Optional<Movie> movie = movieRepository.findMovieByImdbId(id);
        return movie.orElse(null);
    }
}
