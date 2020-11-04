package com.miaoqi.apollo.miaoqispringbootapollo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static Logger logger = (Logger) LoggerFactory.getLogger(HelloController.class);

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String hi() {

        logger.debug("debug log...");
        logger.info("info log...");
        logger.warn("warn log...");

        return "hi, i am from port: " + this.port;
    }

}