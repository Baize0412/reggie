package com.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

public class UploadFileTest {
    @Test
    public void test1() {
        String fileName = "abcabc.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
    }
}
