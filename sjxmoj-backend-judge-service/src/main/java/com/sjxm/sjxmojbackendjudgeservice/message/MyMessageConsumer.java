package com.sjxm.sjxmojbackendjudgeservice.message;

import com.rabbitmq.client.Channel;
import com.sjxm.sjxmojbackendjudgeservice.judge.JudgeService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: 四季夏目
 * @Date: 2024/1/5
 */
@Component
@Slf4j
public class MyMessageConsumer {

    @Resource
    private JudgeService judgeService;

    @SneakyThrows
    @RabbitListener(queues = {"code_queue"},ackMode = "MANUAL")//手动返回ACK
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG)long deliverTag){
        log.info("receiveMessage message = {}",message);
        long questionSubmitId = Long.parseLong(message);
        try{
            judgeService.doJudge(questionSubmitId);
            channel.basicAck(deliverTag,false);
        }catch (Exception e){
            channel.basicNack(deliverTag,false,false);
        }

    }

}
