package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository  extends MongoRepository<MovieWS, String> {

    List<MovieWS> findAllbyGenre(String genre);

}
