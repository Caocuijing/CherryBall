package com.cebbank.springcloudcard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cebbank.springcloudcard.cardInfo.mapper")
public class SpringCloudCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCardApplication.class, args);
    }

}
