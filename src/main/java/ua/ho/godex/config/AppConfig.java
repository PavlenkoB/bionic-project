package ua.ho.godex.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan({"ua.ho.godex.service", "ua.ho.godex.presentation"})
@ImportResource(value = {"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml", "classpath:spring/spring-mvc.xml"})
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"ua.ho.godex"})
public class AppConfig {

}
