package ua.ho.godex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Creator: Pavlenko Bohdan
 * Date: 23.08.2017
 * Project: istore
 */
@SpringBootApplication
public class PlaceHolder {
    static public Integer sum(Integer firsta, Integer second){
        return  firsta+second;
    }

    public static void main(String[] args) {
        SpringApplication.run(PlaceHolder.class, args);
    }
}
