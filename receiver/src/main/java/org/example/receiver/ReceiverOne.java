package org.example.receiver;

import lombok.extern.slf4j.Slf4j;
import org.example.api.MessageOne;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
class ReceiverOne {

    @PostConstruct
    void init(){
        log.info("ReceiverOne created");
    }

    //unique id
    @RabbitListener(id="receiverOne",
            bindings = @QueueBinding(
                    value= @Queue(name="receiver.messageOne"),
                    exchange = @Exchange(name = "messageOne", type = "topic")))
    void on(MessageOne messageOne){
        log.info("{} received", messageOne);
    }
}
