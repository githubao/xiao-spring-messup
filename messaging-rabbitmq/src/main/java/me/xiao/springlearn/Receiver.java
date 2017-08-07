package me.xiao.springlearn;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * 消息接收
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/7 16:13
 */

@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println(String.format("Received <%s>", message));
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
