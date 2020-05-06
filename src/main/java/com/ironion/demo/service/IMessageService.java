package com.ironion.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author huangwc
 * @date 2020/5/1 12:53 上午
 */
public interface IMessageService {

    @RabbitListener(queues = "queue")
    void listern(String message);
}
