package com.zkzn.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


/**
 * 定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务
 */
@FeignClient(value = "echo")
public interface EchoService {

    @RequestMapping(value = "/info")
    String info();

    @RequestMapping(value = "/echo")
    String echo(String data);

    @RequestMapping(value = "/postForm")
    String postForm(Map<String, String> map);

    @RequestMapping(value = "/postData")
    String postData(String postData);
}
