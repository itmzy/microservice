package com.mzy.userservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/itmzy">mazeyuan</a>
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public Map<String, String> getUserInfo(@PathVariable("id") String id) {
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("id", id);
        userInfo.put("name", "User_" + id);
        userInfo.put("email", "user" + id + "@example.com");
        return userInfo;
    }
}
