package ua.ho.godex.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan({"ua.ho.godex.service", "ua.ho.godex.presentation"})
@ImportResource(value = {"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml", "classpath:spring/spring-mvc.xml"})
public class AppConfig {

}
