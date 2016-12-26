package com.sbrf.controllers;

import com.sbrf.jms.Answer;
import com.sbrf.jms.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class RegAuthController {
    @Autowired
    private HttpSession session;

    @Autowired
    private JmsService jmsService;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView authGet() {
        return new ModelAndView("auth");
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ModelAndView authPost(@ModelAttribute(name = "login") String login, @ModelAttribute(name = "password") String password) {
        jmsService.sendStringMessage(login, password);
        Answer answer = jmsService.getUserId();
//        System.out.println(answer.getUserId());
//        System.out.println(answer.isCorrectPassword());

        if (answer.getUserId() != 0 && answer.isCorrectPassword()) {
            session.setAttribute("userId", answer.getUserId());
            return new ModelAndView("authSuccess");
        } else if (answer.getUserId() == 0) {
            return new ModelAndView("noSuchUser");
        } else if (!answer.isCorrectPassword()) {
            return new ModelAndView("wrongPassword");
        } else return new ModelAndView("error");
    }
}
