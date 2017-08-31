package ua.ho.godex.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"ua.ho.godex.service", "ua.ho.godex.presentation"})
@ImportResource(value = {"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml", "classpath:spring/spring-mvc.xml"})
public class AppConfig {

}
