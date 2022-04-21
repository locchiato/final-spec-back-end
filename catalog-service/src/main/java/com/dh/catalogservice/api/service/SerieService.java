package com.dh.catalogservice.api.service;


import com.dh.catalogservice.domain.model.dto.SerieWS;
import com.dh.catalogservice.domain.repository.SerieFeignRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SerieService {

    private SerieFeignRepository serieFeignRepository;

    public SerieService(SerieFeignRepository serieFeignRepository) {
        this.serieFeignRepository = serieFeignRepository;
    }

    public List<SerieWS> getAllMovies(){
        return serieFeignRepository.getSerie();
    }

    //@CircuitBreaker(name = "catalogFromGenre",fallbackMethod = "moviesSerieFallbackMethod")
    //@Retry(name = "catalogFromGenre")
    public List<SerieWS> getAllMoviesByGenre(String genre){
        return serieFeignRepository.getSerieByGenre(genre);
    }

    public SerieWS saveMovie(SerieWS serie){
        return serieFeignRepository.saveSerie(serie);
    }

    private void moviesSerieFallbackMethod(){
        log.error("Circuit breaker was activated");
    }
}
