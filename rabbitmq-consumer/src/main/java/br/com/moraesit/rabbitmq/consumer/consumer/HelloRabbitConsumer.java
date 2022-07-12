package br.com.moraesit.rabbitmq.consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitConsumer {

    private static final Logger log = LoggerFactory.getLogger(HelloRabbitConsumer.class);

    @RabbitListener(queues = "hello")
    public void listen(String message) {
        System.out.println("Consuming message: " + message);
        log.info("Consuming message: {}", message);
    }
}
