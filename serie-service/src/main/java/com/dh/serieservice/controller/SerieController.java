package com.dh.serieservice.controller;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.service.SerieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping()
    public ResponseEntity<?> findAllSerie(){
        log.info("Trayendo todas las series");
        return ResponseEntity.ok().body(serieService.getAllSerie());
    }

    @GetMapping("{genre}")
    public ResponseEntity<?> findAllSerieByGenre(@PathVariable String genre){
        log.info("Trayendo las series con el genero "+ genre);
        return ResponseEntity.ok().body(serieService.findAllByGenre(genre));
    }

    @PostMapping("save")
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie) {
        log.info("Guardando la serie "+ serie);
        return ResponseEntity.ok().body(serieService.saveSerie(serie));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name) {
        log.info("Trayendo todas las serie");
        serieService.deleteByName(name);
        return ResponseEntity.ok().body("Se borro su serie");
    }


}
