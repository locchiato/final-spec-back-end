package com.dh.catalogservice.domain.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CatalogWS {

	private String genre;
	private List<MovieWS> moviesWS;
	private List<SerieWS> serieWS;


	public CatalogWS(String genre, List<MovieWS> moviesWS, List<SerieWS> serieWS) {
		this.genre = genre;
		this.moviesWS = moviesWS;
		this.serieWS = serieWS;
	}
}
