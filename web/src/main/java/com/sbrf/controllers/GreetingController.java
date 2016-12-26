package com.sbrf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class GreetingController {
    @Autowired
    private HttpSession session;

    @RequestMapping("/greeting")
    @ResponseBody
    public ModelAndView greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println(session.getAttribute("userId"));
        return new ModelAndView("greeting");
    }
}
