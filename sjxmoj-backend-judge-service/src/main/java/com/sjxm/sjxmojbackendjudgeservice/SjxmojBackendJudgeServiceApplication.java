package com.sjxm.sjxmojbackendjudgeservice;

import com.sjxm.sjxmojbackendjudgeservice.message.InitRabbitMq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: 四季夏目
 * @Date: 2024/1/4
 */

@SpringBootApplication
@EnableScheduling //启用定时任务
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true) //启用切面Aspect
@ComponentScan("com.sjxm")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.sjxm.sjxmojbackendserviceclient.service"})
public class SjxmojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        //初始化消息队列
        InitRabbitMq.doInit();
        SpringApplication.run(SjxmojBackendJudgeServiceApplication.class,args);
    }
}
