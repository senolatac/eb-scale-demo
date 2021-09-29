package com.example.ebscaledemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
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

    @GetMapping("/api/external-ip")
    public ResponseEntity<?> getExternalIpAddress() throws Exception
    {
        return ResponseEntity.ok(getIp());
    }

    private static String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
