package br.com.moraesit.rabbitmq.producer.producer;

import br.com.moraesit.rabbitmq.producer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureProducer {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper;

    public PictureProducer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(Picture picture) throws IOException {
        var json = objectMapper.writeValueAsString(picture);

        rabbitTemplate.convertAndSend("x.picture", picture.getType(), json);
    }
}
