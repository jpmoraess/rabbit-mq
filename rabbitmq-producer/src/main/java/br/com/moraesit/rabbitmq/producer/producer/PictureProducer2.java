package br.com.moraesit.rabbitmq.producer.producer;

import br.com.moraesit.rabbitmq.producer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureProducer2 {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper;

    public PictureProducer2(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(Picture picture) throws IOException {
        var json = objectMapper.writeValueAsString(picture);

        var sb = new StringBuilder();

        // 1st word is picture source
        sb.append(picture.getSource());
        sb.append(".");

        // 2nd word is based on picture size
        if (picture.getSize() > 4000)
            sb.append("large");
        else
            sb.append("small");
        sb.append(".");

        // 3rd word is picture type
        sb.append(picture.getType());


        rabbitTemplate.convertAndSend("x.picture2", sb.toString(), json);
    }
}
