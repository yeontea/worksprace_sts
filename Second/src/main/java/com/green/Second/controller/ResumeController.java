package com.green.Second.controller;

import com.green.Second.vo.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResumeController {

    @GetMapping("/")
    public String test1(){
        return "test1";
    }


    @PostMapping("/test2")
    public String test2(Resume resume){
        System.out.println(resume);
        return "test2";
    }@PostMapping("/final")
    public String test3(Resume resume){
        System.out.println(resume);
        return "final";
    }

}
