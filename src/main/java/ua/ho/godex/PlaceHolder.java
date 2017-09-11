package ua.ho.godex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import ua.ho.godex.config.AppConfig;

/**
 * Creator: Pavlenko Bohdan
 * Date: 23.08.2017
 * Project: istore
 */
public class PlaceHolder extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        System.setProperty("spring.thymeleaf.cache", "false");
        System.setProperty("spring.mvc.favicon.enabled", "false");
        System.setProperty("spring.profiles.active","jpa,mysql");//todo move
        System.setProperty("current.session.context.class", "thread");//todo move use for lazy load works
        System.setProperty("hibernate.enable_lazy_load_no_trans", "true");//todo move
        SpringApplication.run(AppConfig.class, args);
    }
}
