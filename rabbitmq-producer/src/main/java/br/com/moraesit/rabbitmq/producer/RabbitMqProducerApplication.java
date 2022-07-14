package br.com.moraesit.rabbitmq.producer;

import br.com.moraesit.rabbitmq.producer.entity.Employee;
import br.com.moraesit.rabbitmq.producer.producer.EmployeeJsonProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
//@EnableScheduling
public class RabbitMqProducerApplication implements CommandLineRunner {

    private final EmployeeJsonProducer employeeJsonProducer;

    public RabbitMqProducerApplication(EmployeeJsonProducer employeeJsonProducer) {
        this.employeeJsonProducer = employeeJsonProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int x = 1; x <= 30; x++) {
            TimeUnit.MILLISECONDS.sleep(1500);

            var employee = new Employee(String.valueOf(x), "João Pedro " + x, LocalDate.now());

            employeeJsonProducer.sendMessage(employee);
        }
    }
}
