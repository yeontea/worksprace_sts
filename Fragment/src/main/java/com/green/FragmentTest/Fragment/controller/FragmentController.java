package com.green.FragmentTest.Fragment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentController {

    @GetMapping("/")
    public String main() {
        return "content/content_1";
    }
    @GetMapping("/content_2")
    public String second() {
        return "content/content_2";
    }
}
