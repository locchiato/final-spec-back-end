package com.dh.movieservice.api.queue;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieSender {

    private final MovieService movieService;

    private final RabbitTemplate rabbitTemplate;

    private final Queue movieQueue;

    public Movie send(Movie movie) {
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), movieService.save(movie));
        return movie;
    }

}
