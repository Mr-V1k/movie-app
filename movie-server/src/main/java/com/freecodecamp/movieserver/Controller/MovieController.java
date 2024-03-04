package com.freecodecamp.movieserver.Controller;

import com.freecodecamp.movieserver.Model.Movie;
import com.freecodecamp.movieserver.Service.Movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") String id){
        return new ResponseEntity<>(movieService.getMovieByImdbId(id), HttpStatus.OK);
    }


}
