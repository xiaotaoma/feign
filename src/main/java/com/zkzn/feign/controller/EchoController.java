package com.zkzn.feign.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkzn.feign.service.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;


@Controller
@RequestMapping("/echo")
public class EchoController {
    private Logger logger = LoggerFactory.getLogger(EchoController.class);
    @Autowired
    private EchoService echoService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return echoService.info();
    }

    /**
     * post data
     * @return
     */
    @RequestMapping("/echo")
    @ResponseBody
    public String echo(@RequestBody String postData) {
        try {
            logger.info("postData:"+ URLDecoder.decode(postData, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return echoService.postData(postData);
    }

    @RequestMapping("/postData")
    @ResponseBody
    public String postData(@RequestBody String postData) {
        logger.info("postData:"+postData);
        return echoService.postData(postData);
    }

    @RequestMapping("/postForm")
    public String postForm(@RequestParam Map<String, String> param) {
        logger.info("postData:"+ JSONObject.toJSONString(param));
        return echoService.postForm(param);
    }

    @RequestMapping("/info")
    @ResponseBody
    public String info() {
        return echoService.info();
    }
}
