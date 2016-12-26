package com.sbrf.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.MapMessage;

@Component
public class JmsService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendUserId(long userId, boolean correct) {
//        jmsTemplate.setDefaultDestinationName("StringsFromWebToUser");
        jmsTemplate.send("userIdToWeb", session -> {
            MapMessage msg = session.createMapMessage();
            msg.setLong("userId", userId);
            msg.setBoolean("correct", correct);
            return msg;
        });
    }
}
