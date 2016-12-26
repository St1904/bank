package com.sbrf.controllers;

import com.sbrf.dao.model.User;
import com.sbrf.jms.JmsService;
import com.sbrf.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthController {
    @Autowired
    private JmsService jmsService;

    @Autowired
    private RegisterService registerService;

    public long checkLoginAndPassword(String login, String password) {
        boolean exists = !registerService.checkLoginIsNotUsed(login);
        long userId = 0;
        boolean correct = false;
        if (exists) {
            User user = registerService.readByLogin(login);
            userId = user.getId();
            correct = user.getPassword().equals(password);
        }
        sendUserId(userId, correct);
        return userId;
    }

    public void sendUserId(long userId, boolean correct) {
        jmsService.sendUserId(userId, correct);
    }
}
