package com.pro.Aura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // آدرس اصلی سایت
    @GetMapping("/")
    public String home() {
        return "✅ Spring Boot is running!";
    }

    // آدرس تست
    @GetMapping("/test")
    public String test() {
        return "🚀 Test endpoint is working fine!";
    }
}
