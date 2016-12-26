package com.sbrf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
//@SpringBootApplication
@ComponentScan
public class Application {
    @Autowired
    private HttpSession session;

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView hello(ModelMap model) {
        session.setAttribute("userId", 0L);
        return new ModelAndView("home");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
