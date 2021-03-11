package com.miaoqi.apollo.miaoqispringbootapollo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController extends AbstractController {

    private static Logger logger = (Logger) LoggerFactory.getLogger(HelloController.class);

    @Value("${server.port}")
    String port;

    // @Value("${childField:childField}")
    public String testField;

    public List<String> list;

    // @Value("${x.map:'{}'}")
    // public Map map;

    @GetMapping("/hi")
    public String hi() {

        logger.debug("debug log...");
        logger.info("info log...");
        logger.warn("warn log...");

        return "hi, i am from port: " + this.port;
    }

    @GetMapping("/testfield")
    public String testField() {
        System.out.println("list: " + this.list);
        System.out.println(this.list.get(0));
        // System.out.println("map: " + this.map);
        return this.testField;
    }

    @Value("${x.list:2,3,4}")
    public void setList(List<String> list) {
        System.out.println("asf,pamf");
        this.list = list;
    }

}