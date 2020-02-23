package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","hello pillar");
        return "index";
    }
}
