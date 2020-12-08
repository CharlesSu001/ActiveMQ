/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestConsumer
 * Author:   苏晨宇
 * Date:     2020/12/8 15:02
 * Description: 消费者 消费服务器上的消息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.queue;

import cn.hutool.core.util.RandomUtil;
import com.how2java.util.ActiveMQUtil;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈消费者 消费服务器上的消息〉
 *
 * @author 苏晨宇
 * @create 2020/12/8
 * @since 1.0.0
 */
public class TestConsumer1 {
    //服务地址 默认端口61616
    private static final String url="tcp://127.0.0.1:61616";
    //消费的消息名称
    private static final String topicName="queue_style";
    //消费者有多个 为了区分 随机创建名称
    private static final String consumerName="consumer-"+ RandomUtil.randomString(5);

    public static void main(String[] args) throws JMSException {
        //1.判断端口是否启动Active MQ服务器
        ActiveMQUtil.checkServer();
        System.out.printf("%s消费者启动了。%n",consumerName);

        //2.创建ConnectFactory 绑定地址
        ConnectionFactory factory=new ActiveMQConnectionFactory(url);
        //3.创建Connection
        Connection connection=factory.createConnection();
        //4.启动连接
        connection.start();
        //5.创建会话
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //6.创建一个目标（队列类型）
        Destination destination=session.createQueue(topicName);

        //7.创建一个消费者
        MessageConsumer consumer=session.createConsumer(destination);
        //8.创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage=(TextMessage)message;
                try{
                    System.out.println(consumerName+"接收消息"+textMessage.getText());
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
        });

    }
}
 
