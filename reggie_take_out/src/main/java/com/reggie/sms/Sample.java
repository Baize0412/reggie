package com.reggie.sms;

import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.*;
import com.aliyun.teaopenapi.models.*;
import lombok.extern.slf4j.Slf4j;

public class Sample {

    /**
     * 使用AK&SK初始化账号Client
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static void sms() throws Exception {
        com.aliyun.dysmsapi20170525.Client client = Sample.createClient("LTAI5tSFWm9vq2CCHWU2VrT9", "qyyCvzYDCJoyMVmZZYXW9Ahg7w5IFx");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers("15667012234")
                .setTemplateParam("{\"code\":\"1234\"}");
        // 复制代码运行请自行打印 API 的返回值
        client.sendSms(sendSmsRequest);
        //用户登录名称 jiji@1035839887476572.onaliyun.com
        //AccessKey ID LTAI5tSFWm9vq2CCHWU2VrT9
        //AccessKey Secret qyyCvzYDCJoyMVmZZYXW9Ahg7w5IFx
    }
}