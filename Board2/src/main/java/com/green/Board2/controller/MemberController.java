package com.green.Board2.controller;

import com.green.Board2.sevice.MemberService;
import com.green.Board2.vo.MemberVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Resource(name="memberService")
    private MemberService memberService; // 결합도를 낮추기 위함

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/join")
    public String joinMember(){
        return "join";
    }
    @PostMapping("/insertMem")
    public String insertMember(MemberVO memberVO){
        memberService.insertMember(memberVO);
        return "redirect:/member/login";
    }
    @GetMapping("/detail")
    public String selectBoard(){
        return "board_detail";
    }
    @PostMapping("/login")
    public String login(MemberVO memberVO, HttpSession session){
        MemberVO loginInfo=memberService.login(memberVO);
        if(loginInfo != null){
            //세션에 로그인 정보를 저장
            session.setAttribute("loginInfo", loginInfo);


        }

        return "login_result";

    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginInfo");
        return "redirect:/board/list";
    }

}
