package br.com.moraesit.rabbitmq.producer;

import br.com.moraesit.rabbitmq.producer.producer.HelloRabbitProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class RabbitMqProducerApplication implements CommandLineRunner {

//    private final HelloRabbitProducer helloRabbitProducer;
//
//    public RabbitMqProducerApplication(HelloRabbitProducer helloRabbitProducer) {
//        this.helloRabbitProducer = helloRabbitProducer;
//    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        for (int x = 0; x <= 10; x++) {
//            TimeUnit.MILLISECONDS.sleep(2000);
//            helloRabbitProducer.sendHello("Andressa: " + x);
//        }
    }
}
