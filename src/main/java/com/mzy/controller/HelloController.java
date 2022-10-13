package com.mzy.controller;

import com.mzy.service.RabbitMQSendService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: hello
 * @author: mazhiyuan
 * @create: 2022-10-02 15:12
 **/
@RestController
@Slf4j
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RabbitMQSendService rabbitMQSendService;

    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("hello springboot!!!");
        return "hello springboot";
    }

    @GetMapping("/rabbitmq/{msg}")
    public String testRabbitmq(@PathVariable("msg") String msg) {
        rabbitMQSendService.sendToMQ(msg);
        LOGGER.info("end to send msg!");
        return msg;
    }
}
