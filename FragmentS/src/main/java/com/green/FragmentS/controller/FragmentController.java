package com.green.FragmentS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentController {
         @GetMapping("/")
        public String main(Model model){
             model.addAttribute("name","홍현재");
             model.addAttribute("age",21);
        return "content/list";
        }
        @GetMapping("/goDetail")
    public String detail(){
             return "content/detail";
        }
}
