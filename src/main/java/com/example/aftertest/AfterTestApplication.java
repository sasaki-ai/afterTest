package com.example.aftertest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.afterTest.mapper")
public class AfterTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfterTestApplication.class, args);
    }

}
