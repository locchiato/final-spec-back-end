package com.dh.catalogservice.api.service;


import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieFeignRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieService {

    private MovieFeignRepository movieFeignRepository;

    @Autowired
    public MovieService(MovieFeignRepository movieFeignRepository) {
        this.movieFeignRepository = movieFeignRepository;
    }

    public List<MovieWS> getAllMovies(){
        return movieFeignRepository.getMovie();
    }

    @CircuitBreaker(name = "catalogFromGenre",fallbackMethod = "moviesSerieFallbackMethod")
    @Retry(name = "catalogFromGenre")
    public List<MovieWS> getAllMoviesByGenre(String genre){
        return movieFeignRepository.getMovieByGenre(genre);
    }

    public MovieWS saveMovie(MovieWS movie){
        return movieFeignRepository.saveMovie(movie);
    }

    private void moviesSerieFallbackMethod(){
        log.error("Circuit breaker was activated");
    }

}
