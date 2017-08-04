package me.xiao.springlearn;


import org.joda.time.LocalTime;

/**
 * gradle hello world demo
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/4 17:55
 */

public class HelloWorld {
    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        HelloGreeter greeter = new HelloGreeter();
        System.out.println(greeter.sayHello());
    }
}
