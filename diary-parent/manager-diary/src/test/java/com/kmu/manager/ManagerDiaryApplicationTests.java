package com.kmu.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class ManagerDiaryApplicationTests {

////    spring scurity加密测试
    @Test
    public void testBcrypt() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String raw = "123456";
        for (int i = 0; i < 10; i++) {
            String encode = bCryptPasswordEncoder.encode(raw);
            System.out.println(encode);
        }
    }
}
