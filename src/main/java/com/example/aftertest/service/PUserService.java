package com.example.aftertest.service;

import com.example.aftertest.entity.Response;

import java.util.Map;

public interface PUserService {

    Response OrderPage(Map<String,String> map);

    Response LastOrderPage(Map<String, String> map);
}
