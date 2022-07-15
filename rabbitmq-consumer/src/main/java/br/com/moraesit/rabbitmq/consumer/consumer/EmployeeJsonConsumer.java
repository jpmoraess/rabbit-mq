package br.com.moraesit.rabbitmq.consumer.consumer;

import br.com.moraesit.rabbitmq.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class EmployeeJsonConsumer {

    private static final Logger log = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    private final ObjectMapper objectMapper;

    public EmployeeJsonConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "employee")
    public void listen(String message) throws IOException {
        var employee = objectMapper.readValue(message, Employee.class);

        log.info("Employee is {}", employee);
    }
}
