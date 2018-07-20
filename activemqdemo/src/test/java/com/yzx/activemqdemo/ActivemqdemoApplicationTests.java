package com.yzx.activemqdemo;

import com.yzx.activemqdemo.demo1.MqProducer;
import com.yzx.activemqdemo.demo1.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqdemoApplicationTests {

    @Autowired
    private MqProducer mqProducer;


    @Test
    public void testStringQueue() {

        for (int i = 1; i <= 100; i++) {
            System.out.println("第" + i + "次发送字符串队列消息");
            mqProducer.sendStringQueue("stringQueue", "消息：" + i);
        }
    }


    @Test
    public void testStringListQueue() {

        List<String> idList = new ArrayList<>();
        idList.add("id1");
        idList.add("id2");
        idList.add("id3");

        System.out.println("正在发送集合队列消息ing......");
        mqProducer.sendStringListQueue("stringListQueue", idList);
    }


    @Test
    public void testObjQueue() {

        System.out.println("正在发送对象队列消息......");
        mqProducer.sendObjQueue("objQueue", new User("1", "小明", 20));
    }


    @Test
    public void testObjListQueue() {

        System.out.println("正在发送对象集合队列消息......");

        List<Serializable> userList = new ArrayList<>();
        userList.add(new User("1", "小明", 21));
        userList.add(new User("2", "小雪", 22));
        userList.add(new User("3", "小花", 23));

        mqProducer.sendObjListQueue("objListQueue", userList);
    }


    @Test
    public void testStringTopic() {

        for (int i = 1; i <= 100; i++) {
            System.out.println("第" + i + "次发送字符串主题消息");
            mqProducer.sendStringTopic("stringTopic", "消息：" + i);
        }
    }


    @Test
    public void testStringListTopic() {

        List<String> idList = new ArrayList<>();
        idList.add("id1");
        idList.add("id2");
        idList.add("id3");

        System.out.println("正在发送集合主题消息ing......");
        mqProducer.sendStringListTopic("stringListTopic", idList);
    }


    @Test
    public void testObjTopic() {

        System.out.println("正在发送对象主题消息......");
        mqProducer.sendObjTopic("objTopic", new User("1", "小明", 20));
    }


    @Test
    public void testObjListTopic() {

        System.out.println("正在发送对象集合主题消息......");

        List<Serializable> userList = new ArrayList<>();
        userList.add(new User("1", "小明", 21));
        userList.add(new User("2", "小雪", 22));
        userList.add(new User("3", "小花", 23));

        mqProducer.sendObjListTopic("objListTopic", userList);
    }
}
