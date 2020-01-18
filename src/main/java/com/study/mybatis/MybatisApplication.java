package com.study.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MybatisApplication.class, args);
    }

}
