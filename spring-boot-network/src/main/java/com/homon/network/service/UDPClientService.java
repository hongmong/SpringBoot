package com.homon.network.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Description :
 *
 * @author Homon
 * @version 1.0
 * @date 2021/12/25 13:49
 */
@Service
public class UDPClientService {

    private final static Logger logger = LoggerFactory.getLogger(UDPClientService.class);

    /**
     * 发送消息
     *
     * @param ip      ip地址
     * @param port    端口
     * @param message 消息
     */
    public void sendMessage(String ip, int port, String message) {
        logger.info("Send UDP: {}", message);
        UnicastSendingMessageHandler unicastSendingMessageHandler = new UnicastSendingMessageHandler(ip, port);
        unicastSendingMessageHandler.handleMessage(MessageBuilder.withPayload(message).build());
        logger.info("Send UDP Success!");
    }
}
