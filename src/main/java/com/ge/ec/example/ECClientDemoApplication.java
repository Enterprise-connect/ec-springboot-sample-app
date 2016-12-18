package com.ge.ec.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ECClientDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ECClientDemoApplication.class, args);
    }
}

@RestController
class ECClientDemoController {
    
    @RequestMapping("/hello")
    String hello() {
        return "test";
    }
}
