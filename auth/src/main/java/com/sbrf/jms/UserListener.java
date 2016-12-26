package com.sbrf.jms;

import com.sbrf.controllers.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

@Service
public class UserListener implements MessageListener {
    @Autowired
    private AuthController authController;

    @Override
    public void onMessage(Message message) {
        MapMessage msg = (MapMessage) message;
        try {
//            System.out.println(msg.getString("login"));
//            System.out.println(msg.getString("password"));
            String login = msg.getString("login");
            String password = msg.getString("password");
            authController.checkLoginAndPassword(login, password);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
