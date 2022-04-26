package com.test;

import com.reggie.sms.Sample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

public class UploadFileTest {
    @Test
    public void test1() {
        String fileName = "abcabc.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
    }

    //测试短信服务
    @Test
    public void smstest() throws Exception {
        Sample.sms();
    }
}
