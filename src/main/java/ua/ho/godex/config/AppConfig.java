package ua.ho.godex.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"ua.ho.godex.service", "ua.ho.godex.presentation"})
@PropertySource("classpath:db/hsqldb.properties")
@ImportResource(value = {"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml", "classpath:spring/spring-mvc.xml"})
public class AppConfig {

}
