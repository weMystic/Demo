package com.mzy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: RabbitmqConfig
 * @author: mazhiyuan
 * @create: 2022-10-13 22:16
 **/
@Configuration
public class RabbitmqConfig {
    @Value("${queues.testQueueExchangeName}")
    private String testQueueExchangeName;

    @Bean
    public Queue erduo() {
        // 其三个参数：durable exclusive autoDelete
        // 一般只设置一下持久化即可
        return new Queue("mzy", true);

    }
        /**
         * 配置广播路由器
         * @return
         */
    @Bean
    FanoutExchange testFanoutExchange() {
        return new FanoutExchange(testQueueExchangeName);
    }
}
