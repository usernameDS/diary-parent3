package com.kmu.diaryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiaryEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiaryEurekaApplication.class, args);
    }

}
