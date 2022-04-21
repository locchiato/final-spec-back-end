package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.consumer.CustomLoadBalancerConfiguration;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="movie-service")
@LoadBalancerClient(name = "movie-service", configuration= CustomLoadBalancerConfiguration.class)
public interface MovieFeignRepository {

    @GetMapping("/movies/{genre}")
    List<MovieWS> getMovieByGenre(@PathVariable String genre);

    @PostMapping("/movies/save")
    MovieWS saveMovie(@RequestBody MovieWS movie);

    @GetMapping("/movies/all")
    List<MovieWS> getMovie();


}
