package com.reggie.controller;

import com.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件的上传和下载
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    private String basePath;
    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> update(MultipartFile file) {
        //file是一个临时文件需要转到指定目录
        log.info(file.toString());

        try {
            file.transferTo(new File(basePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
