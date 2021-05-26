package org.example.sender;

import lombok.extern.slf4j.Slf4j;
import org.example.api.MessageOne;
import org.example.api.MessageTwo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    void init(){
        log.info("Sender created");
    }

    @Scheduled(fixedRate = 4000, initialDelay = 10000)
    public void sendMessageOne(){
        MessageOne messageOne = new MessageOne();
        messageOne.setText("one - "+System.currentTimeMillis());

        log.info("send message {}", messageOne);
        rabbitTemplate.convertAndSend("messageOne", "", messageOne);
    }

    @Scheduled(fixedRate = 6000, initialDelay = 10000)
    public void sendMessageTwo(){
        MessageTwo messageTwo = new MessageTwo();
        messageTwo.setText("two - "+System.currentTimeMillis());

        log.info("send message {}", messageTwo);
        rabbitTemplate.convertAndSend("messageTwo", "", messageTwo);
    }
}
