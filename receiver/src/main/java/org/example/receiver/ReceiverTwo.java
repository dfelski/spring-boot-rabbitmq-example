package org.example.receiver;

import lombok.extern.slf4j.Slf4j;
import org.example.api.MessageTwo;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
class ReceiverTwo {

    @PostConstruct
    void init(){
        log.info("ReceiverTwo created");
    }

    //unique id
    @RabbitListener(id="receiverTwo",
            bindings = @QueueBinding(
                    value= @Queue(name="receiver.messageTwo"),
                    exchange = @Exchange(name = "messageTwo", type = "topic")))
    void on(MessageTwo messageTwo){
        log.info("{} received", messageTwo);
    }
}
