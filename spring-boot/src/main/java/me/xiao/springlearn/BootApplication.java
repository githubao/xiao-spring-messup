package me.xiao.springlearn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * 应用上下文
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/7 11:18
 */

@SpringBootApplication
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    /*
    * Let's inspect the beans provided by Spring Boot:
       bootApplication
       commandLineRunner
       helloController
       mbeanExporter
       mbeanServer
       messageConverters
       objectNamingStrategy
       org.springframework.boot.autoconfigure.AutoConfigurationPackages
       org.springframework.boot.autoconfigure.condition.BeanTypeRegistry
       org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration
       org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration
       org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration
       org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory
       org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration
       org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration
       org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration
       org.springframework.boot.autoconfigure.web.JacksonHttpMessageConvertersConfiguration
       org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration
       org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration$RestTemplateConfiguration
       org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor
       org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.store
       org.springframework.context.annotation.internalAutowiredAnnotationProcessor
       org.springframework.context.annotation.internalCommonAnnotationProcessor
       org.springframework.context.annotation.internalConfigurationAnnotationProcessor
       org.springframework.context.annotation.internalRequiredAnnotationProcessor
       org.springframework.context.event.internalEventListenerFactory
       org.springframework.context.event.internalEventListenerProcessor
       propertySourcesPlaceholderConfigurer
       restTemplateBuilder
       spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties
       spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties
       stringHttpMessageConverter
       Bean ended

    * */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot: ");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            System.out.println("Bean ended");
        };
    }

}
