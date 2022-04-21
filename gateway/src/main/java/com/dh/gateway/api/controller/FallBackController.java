package com.dh.gateway.api.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @CircuitBreaker(name = "moviesService")
    @GetMapping("/movies")
    public ResponseEntity<String> moviesFallback() {
        return new ResponseEntity<>("Servidor de filmes esta Indisponible. Por favor, contate a soporte.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CircuitBreaker(name = "seriesService")
    @GetMapping("/series")
    public ResponseEntity<String> seriesFallback() {
        return new ResponseEntity<>("Servidor de series esta Indisponible. Por favor, contate a soporte.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CircuitBreaker(name = "catalogService")
    @GetMapping("/catalog")
    public ResponseEntity<String> catalogFallback() {
        return new ResponseEntity<>("Servidor de catálogos esta Indisponible. Por favor, contate a soporte.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
