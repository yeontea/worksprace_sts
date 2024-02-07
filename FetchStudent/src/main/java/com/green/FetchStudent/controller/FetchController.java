package com.green.FetchStudent.controller;

import com.green.FetchStudent.vo.StuVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 비동기 통신 학습용 controller
// javascript -> fetch
// jquery -> ajax
// react -> axios
@Controller
@RequestMapping("/study")
public class FetchController {
    @GetMapping("/t1")
    public String t1 (){
        return "fetch_test";
    }

    @PostMapping ("/t2")
    @ResponseBody // 해당 메소드는 비동기 통신을 사용하기 때문에
    // 메소드의 마지막 return으로 페이지 전환 하지 않겠다를
    // 스프링에게 알려주는 코드
    public int t2(@RequestParam(name = "name") String name,
                  @RequestParam(name = "age") int age){
        System.out.println("t1 메소드 실행");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return 100;


        }
        @PostMapping("/t3")
        @ResponseBody
        public StuVO t3(StuVO sstuVO){
            System.out.println("t3 메소드 실행~");
            StuVO stuVO = new StuVO();
            stuVO.setStuNum(1);
            stuVO.setStuName("김자바");
            stuVO.setClassCode(1);
            stuVO.setClassName("자바반");
            System.out.println(sstuVO);
            return stuVO;

        }
        @PostMapping("/t4")
        @ResponseBody
        public List<StuVO> t4(){
            System.out.println("t4 메소드 실행~");
            List<StuVO> list = new ArrayList<>();
            for(int i = 1; i < 6; i++){
                StuVO stuVO = new StuVO();
                stuVO.setStuNum(i);
                stuVO.setStuName("자바_"+i);
                stuVO.setClassCode(1+i);
                stuVO.setClassName("자바반_"+i);
                list.add(stuVO);
            }
            return list;

        }






}
