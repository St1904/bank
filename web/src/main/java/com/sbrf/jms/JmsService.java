package com.sbrf.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;

@Component
public class JmsService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendStringMessage(String login, String password) {
//        jmsTemplate.setDefaultDestinationName("StringsFromWebToUser");
        jmsTemplate.send("StringsFromWebToUser", session -> {
            MapMessage msg = session.createMapMessage();
            msg.setString("login", login);
            msg.setString("password", password);
            return msg;
        });
    }

    public Answer getUserId() {
        try {
            MapMessage mapMessage = (MapMessage) jmsTemplate.receive("userIdToWeb");
            Answer answer = new Answer();
            answer.setUserId(mapMessage.getLong("userId"));
            answer.setCorrectPassword(mapMessage.getBoolean("correct"));
            return answer;
        } catch (JMSException e) {
//            e.printStackTrace();
            throw JmsUtils.convertJmsAccessException(e);
        }
    }
}
