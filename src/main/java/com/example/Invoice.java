package com.example;


import lombok.Data;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;


import java.io.IOException;


@Data
public class Invoice {
    private Double amount;
    private String checkCode;


}
