package com.mzy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: RabbitMQSendService
 * @author: mazhiyuan
 * @create: 2022-10-13 22:24
 **/
@Slf4j
@Service
public class RabbitMQSendService {
    @Autowired
    RabbitTemplate rabbitmqTemplate;

    /**
     * 发送到MQ
     *
     * @param msg
     */
    public void sendToMQ(String msg) {
        // Send MQ
        try {
            rabbitmqTemplate.convertAndSend( "mzy", msg);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
}
