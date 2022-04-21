package com.dh.catalogservice.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "SeriesCatalog")
public class SerieWS {

    private String id;
    private String name;
    private String genre;
    private List<SeasonsWS> seasons;

}
