package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@RequestMapping("model")
@Controller
public class ModelController {
    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    public String demo2(Model model){
        model.addAttribute("apple","8");
        model.addAttribute("banana","3");

        HashMap<String, Object> map = new HashMap<>();
        map.put("apple","8");
        map.put("banana","3");
        model.addAllAttributes(map);

        return "/index";
    }

    public ModelAndView demo(){
        // setView() 不能传String，要传View接口的实现类，太麻烦，所以一般在构造的时候之间指明view
        ModelAndView mav = new ModelAndView("/index");

        mav.addObject("apple","8");
        mav.addObject("banana","3");

        HashMap<String, Object> map = new HashMap<>();
        map.put("apple","8");
        map.put("banana","3");
        mav.addAllObjects(map);
        mav.addObject("1234");

        return mav;
    }
    @RequestMapping("/demo2")
    public void demo2(){
        //        添加个条件判断，StringUtils.isEmpty(amount) || “null”.equals(amount)
//        都给他设置为null或者0，这样就可以了。
        try {
            System.out.println(0/0);
        }catch (Exception e){
            logger.error("error ",e);
        }
    }
}
