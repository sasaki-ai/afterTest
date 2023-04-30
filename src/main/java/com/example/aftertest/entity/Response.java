package com.example.aftertest.entity;

import lombok.Data;

@Data
public class Response {
    private int code;
    private String message;
    private Object data;
}
