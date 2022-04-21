package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CatalogService {


    private MovieService movieService;
    private SerieService serieService;

    @Autowired
    public CatalogService(MovieService movieService, SerieService serieService) {
        this.movieService = movieService;
        this.serieService = serieService;
    }

    public CatalogWS getCatalogFromGenre(String genre){

        List<MovieWS> movieWSList = movieService.getAllMoviesByGenre(genre);
        List<SerieWS> serieWSList = serieService.getAllMoviesByGenre(genre);

        return new CatalogWS(genre,movieWSList, serieWSList);
    }






}
