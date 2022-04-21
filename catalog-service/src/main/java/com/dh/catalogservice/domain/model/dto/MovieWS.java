package com.dh.catalogservice.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "MoviesCatalog")
public class MovieWS {

    private String id;
    private String name;
    private String genre;
    private String urlStream;
}
