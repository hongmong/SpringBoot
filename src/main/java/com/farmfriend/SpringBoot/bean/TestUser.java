package com.farmfriend.SpringBoot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by HongMong on 2017/8/30.
 */
@ConfigurationProperties(prefix = "test.user")
public class TestUser {

    private String name;
    private Integer age;
}