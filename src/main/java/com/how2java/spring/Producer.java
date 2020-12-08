/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestProducer
 * Author:   苏晨宇
 * Date:     2020/12/8 15:50
 * Description: 生产者类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者类〉
 *
 * @author 苏晨宇
 * @create 2020/12/8
 * @since 1.0.0
 */
@Component
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination destination;

    public void sendTextMessage(final String text) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
    }

}
 
