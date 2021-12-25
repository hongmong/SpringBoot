package com.homon.network.controller;

import com.homon.network.service.UDPClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :
 *
 * @author Homon
 * @version 1.0
 * @date 2021/12/25 13:46
 */
@RestController
@RequestMapping("udp")
public class UDPController {

    @Autowired
    UDPClientService udpClientService;


    @PostMapping("send")
    public void send(String ip, int port, String message) {
        udpClientService.sendMessage(ip, port, message);
    }
}
