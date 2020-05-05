package com.ironion.demo.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author huangwc
 * @date 2020/5/1 12:53 上午
 */
public interface MessageService {

    @RabbitListener(queues = "queue")
    void listern(String message);
}
