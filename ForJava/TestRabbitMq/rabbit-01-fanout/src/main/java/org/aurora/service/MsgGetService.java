package org.aurora.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author:Aurora
 * @create: 2023-05-31 16:05
 * @Description:
 */
@Service
@Slf4j
public class MsgGetService {
    //接收队列消息
    @RabbitListener(queues = {"queue.fanout.a","queue.fanout.b"})
    public void getMsg(Message message){
        byte[] body = message.getBody();
        log.info("接受到的消息:{}", new String(body));
    }
}
