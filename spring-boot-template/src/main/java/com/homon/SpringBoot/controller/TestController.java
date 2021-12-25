package com.homon.SpringBoot.controller;

import com.homon.SpringBoot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HongMong on 2017/8/30.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

}
