package br.com.moraesit.rabbitmq.consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//@Service
public class FixedRateConsumer {

    private static final Logger log = LoggerFactory.getLogger(FixedRateConsumer.class);

    @RabbitListener(queues = "fixedrate", concurrency = "3-6")
    public void listen(String message) throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(ThreadLocalRandom.current().nextLong(1000, 2000));
        log.info("{} :  consuming {}", Thread.currentThread().getName(), message);
    }
}
