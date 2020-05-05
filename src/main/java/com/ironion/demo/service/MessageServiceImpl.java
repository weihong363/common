package com.ironion.demo.service;

import com.ironion.demo.service.impl.MessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * RabbitMQ服务类
 * @author huangwc
 * @date 2020/5/1 12:37 上午
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 监听
     */
    @RabbitListener(queues = "queue")
    @Override
    public void listern(String message){
        System.out.println(message);
    }
}
