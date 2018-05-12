package com.zkzn.feign.controller;

import com.zkzn.feign.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * 文件的上传下载
 */
@Controller
public class UploadController {
    private Logger logger = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestPart(value = "file")MultipartFile file) {
        logger.info("fileName:"+file.getOriginalFilename());
        return uploadService.upload(file);
    }


}
