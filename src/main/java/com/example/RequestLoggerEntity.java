package com.example;

import lombok.Data;

@Data
public class RequestLoggerEntity {
    private String ip; // 这个字段其实不重要
    private String method; // 请求类型 GET,POST等  其实也不太重要
    private String paramData;
    private String uri; // 比path好，因为更全  类似于/api/check，path是 /check
    private String requestName; // 请求中文名(requestMapping的name属性)
    private String sessionId; //
}
