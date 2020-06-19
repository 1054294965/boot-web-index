package com.example;

import lombok.Data;

@Data
public class LoggerEntity {
    private String ip;
    private String method;
    private String type;
    private String paramData;
    private String uri;
    private String sessionId;


}
