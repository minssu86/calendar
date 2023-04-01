package com.bizplay.calendar.user;

import com.bizplay.calendar.AES256;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class userController {

    private final AES256 aes256;

    private static String testSecret;

    public String getTest(){

        return "";
    }

    @ResponseBody
    @GetMapping("test1")
    public String encryptorTest(String password) throws Exception {
        testSecret = aes256.encrypt(password);
        log.info(testSecret);
        return testSecret;
    }

    @ResponseBody
    @GetMapping("test2")
    public String decryptTest() throws Exception {
        return aes256.decrypt(testSecret);
    }


}
