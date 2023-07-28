/**
 * 文件上传测试
 */
package com.peterjxl.learnspringbootwebadmin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：headerImg={}, photos={}张", headerImg.getSize(), photos.length);

        // 先确定是否有文件上传
        if( ! headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            // 可以保存到文件服务器，例如OSS服务器，这里就先保存到本地
            headerImg.transferTo(new File("D:\\" + originalFilename));
        }

        // 先确定是否有文件上传，不过如果没有，则长度为0，不会执行循环
        for (MultipartFile photo : photos) {
            if (!photo.isEmpty()) {
                String originalFilename = photo.getOriginalFilename();
                // 可以保存到文件服务器，例如OSS服务器，这里就先保存到本地
                photo.transferTo(new File("D:\\" + originalFilename));
            }
        }

        return "main";
    }
}
