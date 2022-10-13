package com.mzy.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @description: worker
 * @author: mazhiyuan
 * @create: 2022-10-13 22:21
 **/
@Component
public class RabbitmqMsgListener {
    /**
     * 批量监听配置
     * @param connectionFactory
     * @return
     */
    @Bean("batchTestListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory batchBumImpListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //设置批量
        factory.setBatchListener(true);
        factory.setConsumerBatchEnabled(true);//设置BatchMessageListener生效
        factory.setBatchSize(100);//设置监听器一次批量处理的消息数量
        return factory;
    }
}
