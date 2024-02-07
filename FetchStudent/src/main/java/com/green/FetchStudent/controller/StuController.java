package com.green.FetchStudent.controller;

import com.green.FetchStudent.service.StuService;
import com.green.FetchStudent.vo.ClassVO;
import com.green.FetchStudent.vo.DetailVO;
import com.green.FetchStudent.vo.StuVO;
import com.green.FetchStudent.vo.StudentVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Resource(name = "stuService")
    StuService stuService;

    @GetMapping("/first")
    public String first(Model model, StuVO stuVO) {
        List<StuVO> list = stuService.selectStu(stuVO);
        model.addAttribute("list", list);
        List<ClassVO> cList = stuService.selectClass();
        model.addAttribute("cList", cList);
        return "stu_manage";

    }

    @PostMapping("/fetchSelect")
    @ResponseBody
    public List<StuVO> fetchSelect(StuVO stuVO) {
        List<StuVO> list = stuService.selectStu(stuVO);
        return list;

    }

    @PostMapping("/detail")
    @ResponseBody
    public DetailVO detail(StuVO stuVO, StudentVO studentVO) {
        StuVO istu = stuService.iDetail(stuVO);
        StudentVO score = stuService.sDetail(studentVO);
        DetailVO result = new DetailVO();
        result.setStuVO(istu);
        result.setStudentVO(score);
        return result;


    }
    @PostMapping("/insertStu")
    @ResponseBody
    public void insertStu(StudentVO studentVO){
        stuService.insertStu(studentVO);
    }

}

