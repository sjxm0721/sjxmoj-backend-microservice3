package com.sjxm.sjxmojbackendquestionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.sjxm.sjxmojbackendquestionservice.mapper") //扫描mybatis使用的mapper文件
@EnableScheduling //启用定时任务
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true) //启用切面Aspect
@ComponentScan("com.sjxm")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.sjxm.sjxmojbackendserviceclient.service"})
public class SjxmojBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SjxmojBackendQuestionServiceApplication.class, args);
    }

}
