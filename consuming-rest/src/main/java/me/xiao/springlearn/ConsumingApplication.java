package me.xiao.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * app 入口
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/4 16:48
 */

@SpringBootApplication
public class ConsumingApplication {
    private static final Logger logger = LoggerFactory.getLogger(ConsumingApplication.class);
    private static final String url = "http://gturnquist-quoters.cfapps.io/api/random";

    public static void main(String[] args) {
        SpringApplication.run(ConsumingApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    //    Quote{type='success', value=Value{id=4, quote='Previous to Spring Boot, I remember XML hell, confusing set up, and many hours of frustration.'}}
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(url, Quote.class);
            logger.info(quote.toString());
        };
    }
}
