package br.com.moraesit.rabbitmq.producer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

//@Service
public class HelloRabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    public HelloRabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendHello(String name) {
        var message = "Hello " + name;
        rabbitTemplate.convertAndSend("hello", message);
    }
}
