package com.bookinginfoservice.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.bookinginfoservice.model.Message;

@Component
public class MessageConsumer {

    @RabbitListener(queues = RConfiguration.QUEUE)
    public void listener(Message message) {
        System.out.println(message);
    }

}
