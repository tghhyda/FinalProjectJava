package com.trangiahuytdtu.finalproject;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {
    @Test
    public void encodePassword(){
        String rawPassword = "java2022";

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println(encodedPassword);

        boolean matchedPassword = passwordEncoder.matches("giahuy", "$2a$10$hmqa/9hK7i1sRtM1lw3sYem/QnoJmeLuYqtPTkDxoSAQC/L/pKMcO");

        System.out.println(matchedPassword);
    }
}
