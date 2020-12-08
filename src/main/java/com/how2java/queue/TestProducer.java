/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestProducer
 * Author:   苏晨宇
 * Date:     2020/12/8 14:40
 * Description: 生产100条消息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.queue;

import com.how2java.util.ActiveMQUtil;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈生产100条消息〉
 *
 * @author 苏晨宇
 * @create 2020/12/8
 * @since 1.0.0
 */
public class TestProducer {
    //服务地址，默认端口61616
    private static final String url="tcp://127.0.0.1:61616";
    //这次发送的消息名称
    private static final String topicName="queue_style";

    public static void main(String[] args) throws JMSException {
        //1.判断端口是否启动了 Active MQ服务器
        ActiveMQUtil.checkServer();
        //2.创建ConnectionFactory 绑定地址
        ConnectionFactory factory=new ActiveMQConnectionFactory(url);
        //3.创建Connection
        Connection connection=factory.createConnection();
        //4.启动连接
        connection.start();
        //5.创建会话
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //6.创建一个目标（队列类型）
        Destination destination=session.createQueue(topicName);
        //7.创建一个生产者
        MessageProducer producer=session.createProducer(destination);

        for(int i=0;i<100;i++){
            //8.创建消息
            TextMessage textMessage=session.createTextMessage("队列消息"+i);
            //9.发送消息
            producer.send(textMessage);
            System.out.println("发送"+textMessage.getText());
        }

        //10.关闭连接
        connection.close();


    }
}
 
