package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.queue.MovieSender;
import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private MovieService movieService;
	private MovieSender movieSender;

	@Autowired
	public MovieController(MovieService movieService, MovieSender movieSender) {

		this.movieService = movieService;
		this.movieSender = movieSender;
	}

	@GetMapping("/{genre}")
	public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(movieService.getListByGenre(genre));
	}

	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok().body(movieService.getAll());
	}

	@PostMapping
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok().body(movieSender.send(movie));
	}
}
