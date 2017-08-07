package me.xiao.springlearn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 实现类
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/7 16:16
 */

@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver, ConfigurableApplicationContext context) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
        this.context = context;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(RabbitMQApplication.queueName, "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();
    }
}
