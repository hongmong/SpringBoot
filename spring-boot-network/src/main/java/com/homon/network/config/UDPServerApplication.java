package com.homon.network.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.dsl.Udp;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

/**
 * Description :
 *
 * @author Homon
 * @version 1.0
 * @date 2021/12/25 13:58
 */
//@Configuration
public class UDPServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(UDPServerApplication.class);

    @Value("${udp.port}")
    private Integer udpPort;

    @Bean
    public IntegrationFlow integrationFlow() {
        logger.info("UDP服务启动成功，端口号为: {}", udpPort);
        return IntegrationFlows.from(Udp.inboundAdapter(udpPort)).channel("udpDefaultChannel").get();
    }

    @Transformer(inputChannel = "udpDefaultChannel", outputChannel = "udpDefaultFilter")
    public String transformer(@Payload byte[] payload, @Headers Map<String, Object> headers) {
        logger.info(headers.toString());
        //把接收的数据转化为字符串
        return new String(payload);
    }

    @Filter(inputChannel = "udpDefaultFilter", outputChannel = "udpDefaultRoute")
    public boolean filter(String message) {
        return true;
    }


    @Router(inputChannel = "udpDefaultRoute")
    public String routing(String message) {
        return "udpDefaultHandle";
    }


    @ServiceActivator(inputChannel = "udpDefaultHandle")
    public void udpMessageHandle(String message) {
        logger.info("udpDefaultHandle receive : {}", message);
    }
}
