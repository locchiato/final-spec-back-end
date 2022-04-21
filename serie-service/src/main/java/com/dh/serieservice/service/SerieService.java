package com.dh.serieservice.service;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    public final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public List<Serie> getAllSerie(){
        return serieRepository.findAll();
    }

    public Serie saveSerie(Serie s){
        return serieRepository.save(s);
    }

    public List<Serie> findAllByGenre(String genre){
        return serieRepository.findAllByGenre(genre);
    }

    public void deleteByName(String name){
        serieRepository.deleteSerieByName(name);
    }

}
