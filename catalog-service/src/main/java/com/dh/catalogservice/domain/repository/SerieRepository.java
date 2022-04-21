package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.SerieWS;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository  extends MongoRepository<SerieWS, String> {

    List<SerieWS> findAllbyGenre(String genre);

}
