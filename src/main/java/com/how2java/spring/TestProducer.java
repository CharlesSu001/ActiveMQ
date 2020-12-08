/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestProducer
 * Author:   苏晨宇
 * Date:     2020/12/8 15:55
 * Description: 测试生产者 生产100条消息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.spring;

import com.how2java.util.ActiveMQUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试生产者 生产100条消息〉
 *
 * @author 苏晨宇
 * @create 2020/12/8
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_jms.xml")
public class TestProducer {
    @Autowired
    private Producer producer;

    @Before
    public void checkServer() {
        ActiveMQUtil.checkServer();
    }

    @Test
    public void testSend() {
        for (int i = 0; i < 100; i++) {
            producer.sendTextMessage("消息 " + i);
        }
    }
}
 
