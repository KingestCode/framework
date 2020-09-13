package com.miaoqi.spring.springwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * 1. 加入mongodb依赖
 * 2. 开启mongodb注解
 * 3. 定义领域对象
 *
 * @author miaoqi
 * @date 2019-03-11
 */
@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringWebfluxDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxDemo01Application.class, args);
    }

}
