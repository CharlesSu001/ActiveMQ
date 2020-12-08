/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ActiveMQUtil
 * Author:   苏晨宇
 * Date:     2020/12/8 14:37
 * Description: 判断服务器是否启动
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.util;

import cn.hutool.core.util.NetUtil;

import javax.swing.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈判断服务器是否启动〉
 *
 * @author 苏晨宇
 * @create 2020/12/8
 * @since 1.0.0
 */
public class ActiveMQUtil {
    public static void main(String[] args){
        checkServer();
    }
    public static void checkServer(){
        if(NetUtil.isUsableLocalPort(8161)){
            JOptionPane.showMessageDialog(null,"ActiveMQ服务器未启动");
            System.exit(1);
        }
    }
}
 
