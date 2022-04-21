package com.dh.catalogservice.configRabbit;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.movie.name}")
    public String movieQueue;
    @Value("${queue.serie.name}")
    public String serieQueue;

    @Bean
    public Queue queueMovie(){
        return new Queue(this.movieQueue, true);
    }

    @Bean
    public Queue queueSerie(){
        return new Queue(this.serieQueue, true);
    }

}
