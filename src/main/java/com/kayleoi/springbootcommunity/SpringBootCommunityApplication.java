package com.kayleoi.springbootcommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kayleoi.springbootcommunity.dao")
public class SpringBootCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommunityApplication.class, args);
    }

}
