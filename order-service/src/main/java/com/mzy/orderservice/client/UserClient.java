package com.mzy.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/user/{id}")
    Map<String, String> getUserInfo(@PathVariable("id") String id);
}
