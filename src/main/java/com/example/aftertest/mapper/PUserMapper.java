package com.example.aftertest.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PUserMapper  {

    List<Map<String,Object>> queryPage(Map<String,String> map);

    int countPage();

    List<Map<String,Object>> lastOrderPage(Map<String,String> map);
}




