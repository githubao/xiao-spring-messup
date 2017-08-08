package me.xiao.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * app
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/7 18:01
 */

@SpringBootApplication
@RestController
public class DockerApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }
}
