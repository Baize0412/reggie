package com.reggie.controller;

import com.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件的上传和下载
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> update(MultipartFile file) {
        //file是一个临时文件需要转到指定目录
        log.info(file.toString());

        String originalFilename = file.getOriginalFilename();   //abc.jpg
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //使用uuid重新生成文件名防止文件名重复
        String fileName = UUID.randomUUID().toString() + suffix;

        log.info("uuid重新生成的文件名为filename = {}",fileName);
        //创建一个目录对象
        File dir = new File(basePath);
        //判断当前目录是否存在
        if (!dir.exists()) {
            //目录不存在，需要创建
            dir.mkdirs();
        }


        try {
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return R.success(fileName);
    }

    /**
     * 文件下载
     *
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {
        try {
            //输入流，通过输入流读取文件内容
            //bug..找不到目录(java.io.FileNotFoundException: /Users/daveluoster/Desktop/reggie/img/3defb521-41ff-4630-be74-cc572fb9d3f7.jpg (No such file or directory))
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
            //输出流，通过输出流将文件写回浏览器，在浏览器展示图片
            ServletOutputStream outputStream = response.getOutputStream();

            //设置响应回去的是什么类型对的文件
            response.setContentType("image/jpeg");  //图片文件

            int len = 0;
            byte[] bytes = new byte[1024];
            //判断有没有读完
            while ((len = fileInputStream.read(bytes)) !=-1){
                outputStream.write(bytes,0,len);    //写回浏览器
                outputStream.flush();   //刷新
            }
            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("未下载到图片..");

        }

    }
}
