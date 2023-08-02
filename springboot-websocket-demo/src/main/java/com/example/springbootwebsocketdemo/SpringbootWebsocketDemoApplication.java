package com.example.springbootwebsocketdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description 启动类
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@EnableSwagger2
@EnableDiscoveryClient
@MapperScan("com.example.springbootwebsocketdemo.mapper")
public class SpringbootWebsocketDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebsocketDemoApplication.class, args);
    }

}
