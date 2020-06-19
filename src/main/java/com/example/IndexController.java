package com.example;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Watchable;
import java.util.HashMap;
import java.util.Random;

@Controller
@RequestMapping(value="/index")
class IndexController {
    @RequestMapping(value="/index",name="index请求")
    public String index(Model model){
        model.addAttribute("name","hello pillar");
//        System.out.println(0/0);
        return "index";
    }
    @ResponseBody
    @RequestMapping(name="发送用户请求",value="/send")
    public String send(User user){
        System.out.println(user);

        return "index";
    }


    public static void main(String[] args) {
        HashMap<String,String> map= new HashMap<String,String>();
        map.put("asdf","asfasf");

        System.out.println(JSON.toJSONString(map));
    }

}
