package com.example.demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${authentication.app.jwtSecret}")
    private String jwtSecret;

    @Value("${authentication.app.jwtExpirationMs}")
    private int jwtExpirationMs;
}
