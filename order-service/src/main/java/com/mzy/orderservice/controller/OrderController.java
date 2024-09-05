package com.mzy.orderservice.controller;


import com.mzy.orderservice.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/itmzy">mazeyuan</a>
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public Map<String, Object> getOrderInfo(@PathVariable("id") String id) {
        Map<String, Object> orderInfo = new HashMap<>();
        orderInfo.put("orderId", id);
        orderInfo.put("product", "Product_" + id);
        orderInfo.put("price", 100 + Integer.parseInt(id));

        // 调用 user-service 获取用户信息
        Map<String, String> userInfo = userClient.getUserInfo("1"); // 示例中使用固定用户ID "1"
        orderInfo.put("userInfo", userInfo);

        return orderInfo;
    }
}
