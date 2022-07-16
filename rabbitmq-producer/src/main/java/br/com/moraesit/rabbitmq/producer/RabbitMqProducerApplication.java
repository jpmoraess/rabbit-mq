package br.com.moraesit.rabbitmq.producer;

import br.com.moraesit.rabbitmq.producer.entity.Picture;
import br.com.moraesit.rabbitmq.producer.producer.PictureProducer2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
//@EnableScheduling
public class RabbitMqProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProducerApplication.class, args);
    }

    private final PictureProducer2 pictureProducer2;

    // valid sources
    private final List<String> sources = List.of("mobile", "web");

    // valid types
    private final List<String> types = List.of("jpg", "png", "svg");

    public RabbitMqProducerApplication(PictureProducer2 pictureProducer2) {
        this.pictureProducer2 = pictureProducer2;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            var picture = new Picture();
            picture.setName("Picture " + i);
            picture.setSize(ThreadLocalRandom.current().nextLong(1, 10000));
            picture.setSource(sources.get(i % sources.size()));
            picture.setType(types.get(i % types.size()));

            pictureProducer2.sendMessage(picture);
        }
    }
}
