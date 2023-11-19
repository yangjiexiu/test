package com.lms.demo;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
    @Autowired
    JavaMailSender sender;
    @Value("${spring.mail.username}")
    String mailName;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        log.info("testinfo");
    }


    @Test
    void testMail() {
        //SimpleMailMessage是一个比较简易的邮件封装，支持设置一些比较简单内容
        SimpleMailMessage message = new SimpleMailMessage();
        //设置邮件标题
        message.setSubject("【标题】1");
        //设置邮件内容
        message.setText("1111");
        //设置邮件发送给谁，可以多个，这里就发给你的QQ邮箱
        message.setTo("754148147@qq.com");
        //邮件发送者，这里要与配置文件中的保持一致
        message.setFrom(mailName);
        //OK，万事俱备只欠发送
        sender.send(message);
    }
    @Test
    void testRedis() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("yjx","1");
        System.out.println(ops.get("yjx"));
    }


}
