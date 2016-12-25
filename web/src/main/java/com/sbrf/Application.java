package com.sbrf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
//@SpringBootApplication
@ComponentScan
public class Application {

    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hi!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
