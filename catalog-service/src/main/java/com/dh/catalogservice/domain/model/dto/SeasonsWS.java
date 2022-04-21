package com.dh.catalogservice.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonsWS {

    private Integer id;
    private Integer seasonNumber;
    private List<ChapterWS> chapters;
}
