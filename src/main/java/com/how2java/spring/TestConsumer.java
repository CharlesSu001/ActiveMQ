/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestConsumer
 * Author:   苏晨宇
 * Date:     2020/12/8 16:03
 * Description: 什么也不做的consumer default启动
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.spring;

import com.how2java.util.ActiveMQUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈什么也不做的consumer default启动〉
 *
 * @author 苏晨宇
 * @create 2020/12/8
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_jms.xml")
public class TestConsumer {
    @Before
    public void checkServer(){
        ActiveMQUtil.checkServer();
    }

    @Test
    public void test(){
        try{
            //保持启动 不退出
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
 
