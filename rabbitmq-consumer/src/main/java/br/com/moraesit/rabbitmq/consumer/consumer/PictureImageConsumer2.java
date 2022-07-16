package br.com.moraesit.rabbitmq.consumer.consumer;

import br.com.moraesit.rabbitmq.consumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureImageConsumer2 {

    private static final Logger log = LoggerFactory.getLogger(PictureImageConsumer2.class);

    private final ObjectMapper objectMapper;

    public PictureImageConsumer2(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = {"q.picture.image", "q.picture.vector", "q.picture.log", "q.picture.filter"})
    public void listen(Message message) throws IOException {
        var json = new String(message.getBody());

        var picture = objectMapper.readValue(json, Picture.class);

        log.info("Consuming picture: {} with routing key: {}", picture, message.getMessageProperties().getReceivedRoutingKey());
    }
}
