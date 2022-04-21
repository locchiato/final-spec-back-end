package com.dh.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Seasons {

    private Integer id;
    private Integer seasonNumber;
    private List<Chapter> chapters;

}
