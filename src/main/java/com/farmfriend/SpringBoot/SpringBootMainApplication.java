package com.farmfriend.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HongMong on 2017/8/16.
 */

@RestController
//@RestController注解等价于@Controller+@ResponseBody的结合，使用这个注解的类里面的方法都以json格式输出
@SpringBootApplication
public class SpringBootMainApplication {

    public static void main (String [] args){
        SpringApplication.run(SpringBootMainApplication.class,args);
    }
}
