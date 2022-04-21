package com.dh.catalogservice.api.controller;


import com.dh.catalogservice.api.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/catalog")
public class CatalogController {

	private CatalogService catalogService;

	@Autowired
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	public ResponseEntity<?> getCatalogByGenre(@PathVariable String genre) {
		log.info("Trayendo el catalogo de peliculas y series con el genero "+ genre);
		return ResponseEntity.ok().body(catalogService.getCatalogFromGenre(genre));
	}

}
