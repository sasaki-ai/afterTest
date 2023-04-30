package com.example.aftertest.controller;

import com.example.aftertest.entity.Response;
import com.example.aftertest.service.PUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/v1/order")
public class OrderController {

    @Resource
    private PUserService pUserService;

    @PostMapping("/list")
    @ResponseBody
    public Response findOrder(@RequestBody Map<String,String> map){
        Response response = pUserService.OrderPage(map);
        if (response.getData()!=null) {
            response.setCode(10000);
            response.setMessage("操作成功");
        }
        return response;
    }

    @PostMapping("/listLastOrder")
    @ResponseBody
    public Response findLastOrder(@RequestBody Map<String,String> map){
        Response response = pUserService.LastOrderPage(map);
        if (response.getData()!=null) {
            response.setCode(10000);
            response.setMessage("操作成功");
        }
        return response;
    }
}
