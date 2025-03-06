package com.allen;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "group2", topic = "AllenTest", nameServer="localhost:9876", selectorExpression="t1")
public class MyConsumer2 implements RocketMQListener<String> {

    @PostConstruct
    public void test(){
        RocketMQMessageListener rocketMQMessageListener = this.getClass().getAnnotation(RocketMQMessageListener.class);
        if(Objects.nonNull(rocketMQMessageListener)) {
            log.info("注册mq 消费者" + this.getClass().getPackage().toString() + this.getClass().getName());
            log.info("注册mq consumerGroup {}", rocketMQMessageListener.consumerGroup());
            log.info("注册mq topic {}", rocketMQMessageListener.topic());
        }

    }
     public void onMessage(String message) {
         log.info("received message: {}", message);
     }
}