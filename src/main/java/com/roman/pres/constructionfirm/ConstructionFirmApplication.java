package com.roman.pres.constructionfirm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ConstructionFirmApplication  implements WebMvcConfigurer {

    public static void main(String[] args){
        SpringApplication.run(ConstructionFirmApplication.class, args);
    }

}
