package com.ironion.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huangwc
 * @date 2020/5/1 12:53 上午
 */
@EnableRabbit
@RunWith(SpringRunner.class)
@SpringBootTest
class MessageServiceImplTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 发送消息
     */
    @Test
    void sendMessage() {
        //不能通过new的方式去使用，否则得到的实例时空的，必须通过autowied的方式来使用
//        MessageServiceImpl service = new MessageServiceImpl();
//        service.sendMessage("test.exchange.direct",null,"这是一条信息");
        rabbitTemplate.convertAndSend("test.exchange.direct",null,"这是一条信息");
    }

    /**
     * 接收消息
     */
    @Test
    void recieve(){
        //只能接收一次
        Object convert = rabbitTemplate.receiveAndConvert("queue2");
        System.out.println(convert);
    }

    /**
     * 创建交换器和队列
     */
    @Test
    void createExchange(){
        //声明一个新的直连交换器
        amqpAdmin.declareExchange(new DirectExchange("test.exchange"));
        //声明一个新的队列
        amqpAdmin.declareQueue(new Queue("queue"));
        //绑定
        amqpAdmin.declareBinding(new Binding("queue",Binding.DestinationType.QUEUE,
                "test.exchange","test",null));
    }
}
