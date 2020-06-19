package com.example;

import lombok.Data;

@Data
public class RequestLoggerEntity {
    private String ip;
    private String method; //
    private String type; // 入参
    private String paramData;
    private String uri;
    private String requestName;
    private String sessionId; //
}
