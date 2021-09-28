package com.example.ebscaledemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sa
 * @date 28.09.2021
 * @time 17:35
 */
@RestController
public class DemoController
{
    @GetMapping("/api/ip")
    public ResponseEntity<?> getIpAddress() throws UnknownHostException
    {
        return ResponseEntity.ok(InetAddress.getLocalHost().getHostAddress());
    }
}
