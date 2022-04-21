package com.dh.catalogservice.domain.model;


import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Catalog {

    @Id
    private String genre;

    private List<MovieWS> moviesWS;
    private List<SerieWS> serieWS;


    public Catalog(String genre, List<MovieWS> moviesWS, List<SerieWS> serieWS) {
        this.genre = genre;
        this.moviesWS = moviesWS;
        this.serieWS = serieWS;
    }
}
