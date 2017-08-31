package ua.ho.godex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

/**
 * Creator: Pavlenko Bohdan
 * Date: 23.08.2017
 * Project: istore
 */
@Controller
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"ua.ho.godex"})
public class PlaceHolder extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        System.setProperty("spring.thymeleaf.cache", "false");
        System.setProperty("spring.profiles.active","jpa,mysql");//todo move
        SpringApplication.run(PlaceHolder.class, args);
    }
}
