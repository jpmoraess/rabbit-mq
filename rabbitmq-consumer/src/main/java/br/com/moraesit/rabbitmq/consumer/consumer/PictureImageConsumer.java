package br.com.moraesit.rabbitmq.consumer.consumer;

import br.com.moraesit.rabbitmq.consumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class PictureImageConsumer {

    private static final Logger log = LoggerFactory.getLogger(PictureImageConsumer.class);

    private final ObjectMapper objectMapper;

    public PictureImageConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "q.picture.image")
    public void listen(String message) throws IOException {
        var picture = objectMapper.readValue(message, Picture.class);

        log.info("On image: {}", picture);
    }
}
