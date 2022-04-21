package com.dh.serieservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Serie {

    @Id
    private String id;
    private String name;
    private String genre;
    private List<Seasons> seasons;

    public Serie(String name, String genre, List<Seasons> seasons) {
        this.name = name;
        this.genre = genre;
        this.seasons = seasons;
    }
}
