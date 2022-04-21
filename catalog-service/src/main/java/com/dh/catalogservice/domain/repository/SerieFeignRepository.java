package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.consumer.CustomLoadBalancerConfiguration;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="serie-service")
@LoadBalancerClient(name = "serie-service", configuration= CustomLoadBalancerConfiguration.class)
public interface SerieFeignRepository {

    @GetMapping("/series/{genre}")
    List<SerieWS> getSerieByGenre(@PathVariable String genre);

    @PostMapping("/series/save")
    SerieWS saveSerie(@RequestBody SerieWS serie);

    @GetMapping("/series/all")
    List<SerieWS> getSerie();
}
