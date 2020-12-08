/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MyMessageListener
 * Author:   苏晨宇
 * Date:     2020/12/8 15:59
 * Description: 监听类 用于获取新的消息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.spring;

import cn.hutool.core.util.RandomUtil;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 〈一句话功能简述〉<br>
 * 〈监听类 用于获取新的消息〉
 *
 * @author 苏晨宇
 * @create 2020/12/8
 * @since 1.0.0
 */
public class MyMessageListener implements MessageListener {
    String name = "consumer-" + RandomUtil.randomString(5);

    public MyMessageListener() {
        System.out.println(name + " started");
    }

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(name + "接收到消息" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
 
