package ua.ho.godex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import ua.ho.godex.presentation.controller.AppErrorController;

@Configuration
@ComponentScan({"ua.ho.godex.service", "ua.ho.godex.presentation"})
@ImportResource(value = {"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml", "classpath:spring/spring-mvc.xml"})
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"ua.ho.godex"})
public class AppConfig {
    @Autowired
    private ErrorAttributes errorAttributes;

    @Bean
    public AppErrorController appErrorController() {
        return new AppErrorController(errorAttributes);
    }
}
