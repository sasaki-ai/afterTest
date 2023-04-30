package com.example.aftertest.service.impl;

import com.example.aftertest.entity.Response;
import com.example.aftertest.mapper.PUserMapper;
import com.example.aftertest.service.PUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PUserServiceImpl implements PUserService {
    @Resource
    private PUserMapper pUserMapper;

    @Override
    @Transactional
    public Response OrderPage(Map<String,String> map) {
        Response response = new Response();
        String page = map.get("page");
        String pers = map.get("pers");
        int persInt = Integer.parseInt(pers);
        int pageInt = (Integer.parseInt(page)-1) * persInt;
        map.put("page",String.valueOf(pageInt));
        List<Map<String, Object>> pUsers = pUserMapper.queryPage(map);
        int countPage = pUserMapper.countPage();
        int totalPageNum = (countPage+persInt - 1) / persInt;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data",pUsers);
        hashMap.put("total",totalPageNum);
        hashMap.put("page",Integer.parseInt(page));
        hashMap.put("pers",persInt);
        if (pageInt > totalPageNum) {
            hashMap.put("hasNext",false);
        }else {
            hashMap.put("hasNext",true);
        }
        response.setData(hashMap);
        return response;
    }

    @Override
    @Transactional
    public Response LastOrderPage(Map<String, String> map) {
        Response response = new Response();
        String page = map.get("page");
        String pers = map.get("pers");
        int persInt = Integer.parseInt(pers);
        int pageInt = (Integer.parseInt(page)-1) * persInt;
        map.put("page",String.valueOf(pageInt));
        List<Map<String, Object>> pUsers = pUserMapper.lastOrderPage(map);
        int countPage = pUserMapper.countPage();
        int totalPageNum = (countPage+persInt - 1) / persInt;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data",pUsers);
        hashMap.put("total",totalPageNum);
        hashMap.put("page",Integer.parseInt(page));
        hashMap.put("pers",persInt);
        if (pageInt > totalPageNum) {
            hashMap.put("hasNext",false);
        }else {
            hashMap.put("hasNext",true);
        }
        response.setData(hashMap);
        return response;
    }
}
